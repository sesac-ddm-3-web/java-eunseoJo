package co.kr.SimpleBoard.infra.comment;

import co.kr.SimpleBoard.domain.comments.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CommentRepository extends JpaRepository<Comment,Long> {
    List<Comment> findAllByBoardBoardId(Long boardId);
    Comment findByCommentId(Long commentId);
}
