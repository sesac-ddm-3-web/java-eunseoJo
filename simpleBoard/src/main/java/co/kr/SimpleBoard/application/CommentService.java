package co.kr.SimpleBoard.application;

import co.kr.SimpleBoard.domain.board.Board;
import co.kr.SimpleBoard.domain.comments.Comment;
import co.kr.SimpleBoard.domain.user.User;
import co.kr.SimpleBoard.infra.board.BoardRepository;
import co.kr.SimpleBoard.infra.comment.CommentRepository;
import co.kr.SimpleBoard.infra.user.UserRepository;
import co.kr.SimpleBoard.presentation.comment.CommentResponseDto;
import co.kr.SimpleBoard.presentation.comment.CreateCommentRequestDto;
import co.kr.SimpleBoard.presentation.exception.BusinessException;
import co.kr.SimpleBoard.presentation.exception.ExceptionCode;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final BoardRepository boardRepository;
    private final UserRepository userRepository;

    // 댓글 조회하기
    public List<CommentResponseDto> getComments(Long postId){
        List<Comment> comments = commentRepository.findAllByBoardBoardId(postId);

        return comments.stream()
                .map(comment -> CommentResponseDto.toDto(comment))
                .toList();
    }
    // 댓글 작성하기
    @Transactional
    public void createComment(Long postId, CreateCommentRequestDto dto, String username){
        // 게시글 조회하기
        Board board = boardRepository.findByBoardId(postId)
                .orElseThrow(() -> new BusinessException(ExceptionCode.BOARD_NOT_FOUND));
        // 작성자 조회하기
        User author = userRepository.findByUsername(board.getUser().getUsername())
                .orElseThrow(() -> new BusinessException(ExceptionCode.USER_NOT_FOUND));

        // 댓글 작성자
        User commentUser = userRepository.findByUsername(username)
                .orElseThrow(() -> new BusinessException(ExceptionCode.USER_NOT_FOUND));

        // 댓글 객체 생성하기
        Comment comment = Comment.builder()
                .board(board)
                .content(dto.content())
                .user(commentUser)
                .build();

        // 저장하기
        board.addComment(comment);

    }
    // 댓글 삭제하기
    @Transactional
    public void deleteComment(Long commentId, String username){
        Comment comment = commentRepository.findByCommentId(commentId);
        // 인가
        if(!comment.getUser().getUsername().equals(username)){
            throw new BusinessException(ExceptionCode.ACCESS_FORBIDDEN);
        }
        commentRepository.delete(comment);
    }

}
