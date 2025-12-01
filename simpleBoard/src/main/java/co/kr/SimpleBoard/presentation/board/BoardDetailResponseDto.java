package co.kr.SimpleBoard.presentation.board;

import co.kr.SimpleBoard.domain.board.Board;

import java.time.LocalDateTime;

public record BoardDetailResponseDto(
        String title, String content, String author,int viewCount,  LocalDateTime createdAt
) {
    public static BoardDetailResponseDto toDto(Board board){
        return new BoardDetailResponseDto(
                board.getTitle(),
                board.getContent(),
                board.getUser().getUsername(),
                board.getViewCount(),
                board.getCreatedAt()
                );
    }

}
