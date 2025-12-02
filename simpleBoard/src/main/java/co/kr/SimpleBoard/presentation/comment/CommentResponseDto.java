package co.kr.SimpleBoard.presentation.comment;

import co.kr.SimpleBoard.domain.comments.Comment;

import java.time.LocalDateTime;

public record CommentResponseDto(
        Long id,
        String author,
        String content,
        LocalDateTime createdAt
) {
    public static CommentResponseDto toDto(Comment comment)
    {
        return new CommentResponseDto(
                comment.getCommentId(),
                comment.getUser().getUsername(),
                comment.getContent(),
                comment.getCommentDate()
        );
    }
}
