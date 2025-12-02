package co.kr.SimpleBoard.presentation.board;

import co.kr.SimpleBoard.domain.board.Board;

import java.time.LocalDateTime;

public record BoardListResponseDto(
        Long id,
        String title,
        String author,
        int viewCount,
        LocalDateTime createdAt
) {
    public static BoardListResponseDto toDto(Board board){
        return new BoardListResponseDto(
                board.getBoardId(),
                board.getTitle(),
                board.getUser().getUsername(),
                board.getViewCount(),
                board.getCreatedAt()
        );
    }
}
