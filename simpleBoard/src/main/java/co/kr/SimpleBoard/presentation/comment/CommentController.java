package co.kr.SimpleBoard.presentation.comment;

import co.kr.SimpleBoard.application.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CommentController {
    private final CommentService commentService;
    // 댓글 조회하기
    @GetMapping("/posts/{postId}/comments")
    public ResponseEntity<List<CommentResponseDto>> getComments(@PathVariable Long postId){
        List<CommentResponseDto> responseDtos = commentService.getComments(postId);
        return ResponseEntity.ok(responseDtos);
    }

    // 댓글 생성하기
    @PostMapping("/posts/{postId}/comments")
    public ResponseEntity<String> createComment(
            @PathVariable Long postId,
            @RequestBody CreateCommentRequestDto dto,
            @AuthenticationPrincipal String username){
        commentService.createComment(postId,dto, username );
        return ResponseEntity.ok("댓글 작성 완료!");
    }

    // 댓글 삭제하기
    @DeleteMapping("/comments/{commentId}")
    public ResponseEntity<String> deleteComment(@PathVariable Long commentId, @AuthenticationPrincipal String username){
        commentService.deleteComment(commentId, username);
        return ResponseEntity.ok("댓글 삭제 완료!");
    }

}
