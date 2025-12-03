// 전역 변수 및 상수
const API_BASE_URL = ''; // Spring Boot 서버가 같은 origin에서 실행되므로 비워둡니다.

// JWT 토큰을 위한 유틸리티
/**
 * JWT 토큰에서 Payload(사용자 정보)를 디코딩하여 JSON 객체로 반환
 * @returns {object | null} JWT Payload 객체 또는 토큰이 없을 경우 null
 */

 const getToken = () => localStorage.getItem('token');
 const setToken = (token) => localStorage.setItem('token', token);
 const removeToken = () => localStorage.removeItem('token');

 function decodeToken(){
    const token = getToken();

    if(!token) return null;

    try{
        // header.payload.signature
        const parts = token.split('.');
        if (parts.length !== 3) return null;

        // Base64Url 디코딩
        const base64 = parts[1].replace(/-/g, '+').replace(/_/g, '/');
        const jsonPayload = decodeURIComponent(atob(base64).split('').map(function(c) {
            return '%' + ('00' + c.charCodeAt(0).toString(16)).slice(-2);
        }).join(''));

        return JSON.parse(jsonPayload);
    }catch(e){
        console.log("JWT 디코딩 실패 : ", e);
        return null;
    }

 }

 /**
  * 현재 로그인한 사용자의 username을 반환
  * @returns {string | null} username 또는 로그인하지 않았을 경우 null
  */
     function getCurrentUsername() {
         const payload = decodeToken();
         // 백엔드에서 JWT 생성 시 username 필드를 'sub' (Subject)로 설정했다고 가정합니다.
         return payload ? payload.sub : null;
     }





// API 호출을 위한 공통 함수
async function fetchApi(url, options = {}) {
    const headers = {
        'Content-Type': 'application/json',
        ...options.headers,
    };

    const token = getToken();
    if (token) {
        headers['Authorization'] = `Bearer ${token}`;
    }

    const response = await fetch(API_BASE_URL + url, { ...options, headers });

    if (response.status === 401) {
        // 인증 실패 시 로그인 페이지로 리디렉션
        alert('인증이 필요하거나 세션이 만료되었습니다. 다시 로그인해주세요.');
        removeToken();
        window.location.href = '/login.html';
        return;
    }
    
    if (!response.ok) {
        const errorData = await response.json().catch(() => ({ message: '서버와 통신 중 에러가 발생했습니다.' }));
        throw new Error(errorData.message || '알 수 없는 에러');
    }

    if (response.headers.get('Content-Type')?.includes('application/json')) {
        return response.json();
    }
    return response.text();
}


// UI 업데이트 (로그인 상태에 따라)
function updateUI() {
    const token = getToken();
    const loginBtn = document.getElementById('login-btn');
    const signupBtn = document.getElementById('signup-btn');
    const writeBtn = document.getElementById('write-btn');
    const logoutBtn = document.getElementById('logout-btn');

    if (token) {
        loginBtn && (loginBtn.style.display = 'none');
        signupBtn && (signupBtn.style.display = 'none');
        writeBtn && (writeBtn.style.display = 'inline-block');
        logoutBtn && (logoutBtn.style.display = 'inline-block');
    } else {
        loginBtn && (loginBtn.style.display = 'inline-block');
        signupBtn && (signupBtn.style.display = 'inline-block');
        writeBtn && (writeBtn.style.display = 'none');
        logoutBtn && (logoutBtn.style.display = 'none');
    }
}

// 로그아웃 처리
function handleLogout() {
    const logoutBtn = document.getElementById('logout-btn');
    if (logoutBtn) {
        logoutBtn.addEventListener('click', () => {
            removeToken();
            alert('로그아웃 되었습니다.');
            window.location.href = '/';
        });
    }
}


// 페이지별 로직 실행
document.addEventListener('DOMContentLoaded', () => {
    updateUI();
    handleLogout();

    const path = window.location.pathname;

    if (path === '/' || path === '/index.html') {
        loadPosts();
    } else if (path === '/post.html') {
        loadPostDetail();
        handleCommentSubmit();
    } else if (path === '/write.html') {
        handleWriteForm();
    } else if (path === '/login.html') {
        handleLoginForm();
    } else if (path === '/signup.html') {
        handleSignupForm();
    }
});


// --- index.html: 게시글 목록 로드 ---
async function loadPosts() {
    const postList = document.getElementById('post-list');
    const pagination = document.querySelector('.pagination');
    if (!postList) return;

    const params = new URLSearchParams(window.location.search);
    const page = params.get('page') || 0;
    const size = params.get('size') || 10;

    try {
        const data = await fetchApi(`/posts?page=${page}&size=${size}`);
        postList.innerHTML = ''; // 기존 목록 초기화
        data.content.forEach(post => {
            const li = document.createElement('li');
            li.innerHTML = `
                <a href="/post.html?id=${post.id}">${post.title}</a>
                <div>
                    <span>작성자: ${post.author}</span> |
                    <span>작성일: ${new Date(post.createdAt).toLocaleDateString()}</span>
                </div>
            `;
            postList.appendChild(li);
        });

        renderPagination(data);

    } catch (error) {
        console.error('게시글 로딩 실패:', error);
        postList.innerHTML = '<li>게시글을 불러오는 데 실패했습니다.</li>';
    }
}

function renderPagination(pageData) {
    const pagination = document.querySelector('.pagination');
    if (!pagination) return;
    pagination.innerHTML = '';

    const { number, totalPages, first, last } = pageData;

    if (!first) {
        const prev = document.createElement('a');
        prev.href = `/?page=${number - 1}`;
        prev.innerText = '이전';
        pagination.appendChild(prev);
    }

    for (let i = 0; i < totalPages; i++) {
        const pageLink = document.createElement(i === number ? 'span' : 'a');
        if (i !== number) {
            pageLink.href = `/?page=${i}`;
        }
        pageLink.innerText = i + 1;
        pageLink.className = i === number ? 'active' : '';
        pagination.appendChild(pageLink);
    }

    if (!last) {
        const next = document.createElement('a');
        next.href = `/?page=${number + 1}`;
        next.innerText = '다음';
        pagination.appendChild(next);
    }
}


// --- post.html: 게시글 상세 및 댓글 ---
async function loadPostDetail() {
    const postDetail = document.getElementById('post-detail');
    if (!postDetail) return;

    const params = new URLSearchParams(window.location.search);
    const postId = params.get('id');
    const currentUsername = getCurrentUsername();

    if (!postId) {
        postDetail.innerHTML = '<p>게시글 ID가 올바르지 않습니다.</p>';
        return;
    }

    try {
        const post = await fetchApi(`/posts/${postId}`);

        // ★★★ 게시글 작성자와 현재 사용자가 일치하는지 확인 ★★★
        const isAuthor = currentUsername && currentUsername === post.author;

        postDetail.innerHTML = `
            <h2>${post.title}</h2>
            <div class="post-meta">
                <span>작성자: ${post.author}</span> |
                <span>작성일: ${new Date(post.createdAt).toLocaleDateString()}</span>
                <span>조회수: ${post.viewCount}</spain>
            </div>
            <div class="post-actions">
                 ${isAuthor ? `<button id="delete-post-btn" data-id="${postId}">게시글 삭제</button>` : ''}
            </div>
            <div class="post-content">
                <p>${post.content.replace(/\n/g, '<br>')}</p>
            </div>
        `;

        if (isAuthor) {
            handleDeletePost(postId, currentUsername); // 삭제 이벤트 핸들러 연결
        }

        loadComments(postId);
    } catch (error) {
        console.error('게시글 상세 정보 로딩 실패:', error);
        postDetail.innerHTML = '<p>게시글을 불러오는 데 실패했습니다.</p>';
    }
}

// --- 게시글 삭제 처리 함수 추가 ---
function handleDeletePost(postId, username) {
    const deleteBtn = document.getElementById('delete-post-btn');
    if (!deleteBtn) return;

    deleteBtn.addEventListener('click', async () => {
        if (!confirm('게시글을 삭제하시겠습니까?')) {
            return;
        }

        try {
            await fetchApi(`/posts/${postId}`, {
                method: 'DELETE',
            });
            alert('게시글이 성공적으로 삭제되었습니다.');
            window.location.href = '/';
        } catch (error) {
            console.error('게시글 삭제 실패:', error);
            alert(`게시글 삭제 실패: ${error.message}`);
        }
    });
}

async function loadComments(postId) {
    const commentList = document.getElementById('comment-list');
    const currentUsername = getCurrentUsername();
    //console.log(currentUsername);
    if (!commentList) return;

    try {
        const comments = await fetchApi(`/posts/${postId}/comments`);

        commentList.innerHTML = '';
        if (comments.length > 0) {
            comments.forEach(comment => {
                // 댓글 작성자와 현재 사용자가 일치하는가?
                const isCommentAuthor = currentUsername && currentUsername === comment.author;
                // console.log(isCommentAuthor); true
                const li = document.createElement('li');
                li.innerHTML = `
                    <p>${comment.content}</p>
                    <small>작성자: ${comment.author} | 작성일: ${new Date(comment.createdAt).toLocaleDateString()}</small>
                    ${isCommentAuthor ? `<button class="delete-comment-btn" data-comment-id="${comment.id}" data-post-id="${postId}">삭제</button>` : ''}
                `;
                commentList.appendChild(li);
            });

            // ★★★ 댓글 삭제 이벤트 핸들러 연결 ★★★
             document.querySelectorAll('.delete-comment-btn').forEach(button => {
                button.addEventListener('click', handleDeleteComment);
             });
        } else {
            commentList.innerHTML = '<li>작성된 댓글이 없습니다.</li>';
        }
    } catch (error) {
        console.error('댓글 로딩 실패:', error);
        commentList.innerHTML = '<li>댓글을 불러오는 데 실패했습니다.</li>';
    }
}


// --- 댓글 삭제 처리 함수 추가 ---
async function handleDeleteComment(e) {
    const commentId = e.target.dataset.commentId;
    const postId = e.target.dataset.postId;

    if (!confirm('댓글을 삭제하시겠습니까?')) {
        return;
    }

    try {
        // 백엔드 API 경로는 `/posts/{postId}/comments/{commentId}`라고 가정합니다.
        await fetchApi(`/comments/${commentId}`, {
            method: 'DELETE',
        });
        alert('댓글이 성공적으로 삭제되었습니다.');
        loadComments(postId, getCurrentUsername()); // 삭제 후 댓글 목록 새로고침
    } catch (error) {

        console.error('댓글 삭제 실패:', error);
        alert(`댓글 삭제 실패: ${error.message}`);
    }
}

function handleCommentSubmit() {
    const commentForm = document.getElementById('comment-form');
    if (!commentForm) return;

    const params = new URLSearchParams(window.location.search);
    const postId = params.get('id');

    commentForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const content = document.getElementById('comment-content').value;
        if (!content.trim()) {
            alert('댓글 내용을 입력하세요.');
            return;
        }

        try {
            await fetchApi(`/posts/${postId}/comments`, {
                method: 'POST',
                body: JSON.stringify({ content }),
            });
            document.getElementById('comment-content').value = '';
            loadComments(postId); // 댓글 목록 새로고침
        } catch (error) {
            console.error('댓글 작성 실패:', error);
            alert(`댓글 작성 실패: ${error.message}`);
        }
    });
}


// --- write.html: 글쓰기 폼 처리 ---
function handleWriteForm() {
    const writeForm = document.getElementById('write-form');
    if (!writeForm) return;

    writeForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const title = document.getElementById('title').value;
        const content = document.getElementById('content').value;

        try {
            await fetchApi('/posts', {
                method: 'POST',
                body: JSON.stringify({ title, content }),
            });
            alert('게시글이 성공적으로 작성되었습니다.');
            window.location.href = '/';
        } catch (error) {
            console.error('글 작성 실패:', error);
            alert(`글 작성 실패: ${error.message}`);
        }
    });
}


// --- login.html: 로그인 폼 처리 ---
function handleLoginForm() {
    const loginForm = document.getElementById('login-form');
    if (!loginForm) return;

    loginForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        try {
            const data = await fetchApi('/login', {
                method: 'POST',
                body: JSON.stringify({ username, password }),
            });
            setToken(data.token);
            alert('로그인 성공!');
            window.location.href = '/';
        } catch (error) {
            console.error('로그인 실패:', error);
            alert(`로그인 실패: ${error.message}`);
        }
    });
}


// --- signup.html: 회원가입 폼 처리 ---
function handleSignupForm() {
    const signupForm = document.getElementById('signup-form');
    if (!signupForm) return;

    signupForm.addEventListener('submit', async (e) => {
        e.preventDefault();
        const username = document.getElementById('username').value;
        const password = document.getElementById('password').value;

        try {
            const response = await fetchApi('/signup', {
                method: 'POST',
                body: JSON.stringify({ username, password }),
            });
            alert('회원가입 성공! 로그인 페이지로 이동합니다.');
            window.location.href = '/login.html';
        } catch (error) {
            console.error('회원가입 실패:', error);
            alert(`회원가입 실패: ${error.message}`);
        }
    });
}