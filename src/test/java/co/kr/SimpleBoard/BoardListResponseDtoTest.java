package co.kr.SimpleBoard;

import co.kr.SimpleBoard.domain.board.Board;
import co.kr.SimpleBoard.domain.user.User;
import co.kr.SimpleBoard.presentation.board.BoardListResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BoardListResponseDtoTest {

    @Test
    @DisplayName("Board 엔티티가 Dto로 정확하게 변환되는지 테스트한다.")
    void entityToDtoTest(){
        // given
        User user = User.builder()
                .username("test1")
                .password("1234")
                .build();

        Board board = Board.builder()
                .title("test title")
                .content("test content")
                .user(user)
                .build();

        // when
        BoardListResponseDto dto = BoardListResponseDto.toDto(board);

        // then
        assertThat(dto.author()).isEqualTo("test1");
        assertThat(dto.title()).isEqualTo("test title");
    }
}
