package co.kr.SimpleBoard.application;

import co.kr.SimpleBoard.domain.board.Board;
import co.kr.SimpleBoard.domain.user.User;
import co.kr.SimpleBoard.infra.board.BoardRepository;
import co.kr.SimpleBoard.infra.user.UserRepository;
import co.kr.SimpleBoard.presentation.board.BoardDetailResponseDto;
import co.kr.SimpleBoard.presentation.board.BoardListResponseDto;
import co.kr.SimpleBoard.presentation.board.PostCreateRequestDto;
import co.kr.SimpleBoard.presentation.exception.BusinessException;
import co.kr.SimpleBoard.presentation.exception.ExceptionCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    //게시글 생성
    @Transactional
    public void createPost(PostCreateRequestDto dto,  String username){
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new BusinessException(ExceptionCode.USER_NOT_FOUND));

        // 게시글 객체 생성
        Board board = Board.builder()
                .title(dto.title())
                .user(user)
                .content(dto.content())
                .build();

        // 저장
        boardRepository.save(board);
    }

    // 게시글 목록 조회
    public Page<BoardListResponseDto> getBoardList(int page, int size){
        Pageable pageable = PageRequest.of(page, size, Sort.by("createdAt").descending());
        Page<Board> boards = boardRepository.findAll(pageable);
        return boards.map(board -> BoardListResponseDto.toDto(board));

    }

    @Transactional
    // 게시글 상세 조회
    public BoardDetailResponseDto getBoardDetailById(Long id){
        // 조회수 카운팅
        Board board = boardRepository.findByBoardId(id)
                .orElseThrow(() -> new BusinessException(ExceptionCode.BOARD_NOT_FOUND));
        board.increaseViewCount();
        return BoardDetailResponseDto.toDto(board);

    }

    // 게시글 삭제
    @Transactional
    public void deletePost(Long id, String username){

        // 게시판 조회
        Board board = boardRepository.findByBoardId(id)
                .orElseThrow(() -> new BusinessException(ExceptionCode.BOARD_NOT_FOUND));

        // 게시판 작성 조회
        if(!board.getUser().getUsername().equals(username)){
            throw new BusinessException(ExceptionCode.ACCESS_FORBIDDEN);
        }
        // 삭제
        boardRepository.delete(board);

    }


}
