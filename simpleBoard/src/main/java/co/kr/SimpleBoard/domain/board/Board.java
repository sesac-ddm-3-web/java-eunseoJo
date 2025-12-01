package co.kr.SimpleBoard.domain.board;

import co.kr.SimpleBoard.domain.comments.Comment;
import co.kr.SimpleBoard.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@Table(name="board")
public class Board {
    // 제목, 내용, 작성자, 조회수, 작성일시
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long boardId;

    @Column(nullable = false)
    private String title;

    @Lob
    @Column(nullable = false)
    private String content;

    @Column(columnDefinition = "integer default 0", nullable = false)
    private int viewCount;

    @CreationTimestamp
    @Column(nullable = false)
    private LocalDateTime createdAt;

    // 작성자 (N:1)
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    // 댓글 목록 (1:N)
    @OneToMany(mappedBy = "board",cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public Board(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.viewCount = 0;
    }

    // 비즈니스로직 (게시글 수정, 조회수 증가, 댓글 작성)
    public void update(String title, String content){
        this.title = title;
        this.content = content;
    }

    public void increaseViewCount(){
        this.viewCount++;
    }

    public void addComment(Comment comment){
        this.comments.add(comment);
    }
}
