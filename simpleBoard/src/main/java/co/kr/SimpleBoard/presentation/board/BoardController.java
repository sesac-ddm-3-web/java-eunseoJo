package co.kr.SimpleBoard.presentation.board;

import co.kr.SimpleBoard.application.BoardService;
import lombok.RequiredArgsConstructor;

import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/posts")
public class BoardController {
    private final BoardService boardService;


    // 게시글 생성
    @PostMapping
    public ResponseEntity<String> createPost(
            @RequestBody PostCreateRequestDto requestDto,
            @AuthenticationPrincipal String username
    ){
        boardService.createPost(requestDto, username);

        return ResponseEntity.ok("게시글 작성 완료!");
    }

    // 게시글 목록 페이징해서 조회
    @GetMapping
    public ResponseEntity<Page<BoardListResponseDto>> getBoardList(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        Page<BoardListResponseDto> response = boardService.getBoardList(page, size);
        return ResponseEntity.ok(response);
    }

    // 게시글 상세정보 조회 (단건 조회)
    @GetMapping("/{id}")
    public ResponseEntity<BoardDetailResponseDto> getBoardById(@PathVariable Long id){
        BoardDetailResponseDto response = boardService.getBoardDetailById(id);
        return ResponseEntity.ok(response);
    }

    // 게시글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<String>deletePost(
            @PathVariable Long id,
            @AuthenticationPrincipal String username
    ){
        boardService.deletePost(id, username);
        return ResponseEntity.ok("게시글 삭제 완료!");
    }



}
