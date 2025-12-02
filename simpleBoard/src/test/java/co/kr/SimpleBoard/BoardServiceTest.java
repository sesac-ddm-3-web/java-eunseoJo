package co.kr.SimpleBoard;

import co.kr.SimpleBoard.application.BoardService;
import co.kr.SimpleBoard.domain.board.Board;
import co.kr.SimpleBoard.domain.user.User;
import co.kr.SimpleBoard.infra.board.BoardRepository;
import co.kr.SimpleBoard.presentation.board.BoardListResponseDto;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class BoardServiceTest {

    @Mock
    private BoardRepository boardRepository;

    @InjectMocks
    private BoardService boardService;

    @Test
    @DisplayName("게시글 목록을 페이징하여 조회한다. ")
    void getBoardListTest(){
        // given
        User user = User.builder().username("test1").password("1234").build();
        Board board1 = Board.builder().title("post1").content("content1").user(user).build();
        Board board2 = Board.builder().title("post2").content("content2").user(user).build();

        List<Board> fakeList = List.of(board1, board2);
        Page<Board> fakePage = new PageImpl<>(fakeList);

        given(boardRepository.findAll(any(Pageable.class))).willReturn(fakePage);
        // when
        Page<BoardListResponseDto> result = boardService.getBoardList(0, 10);
        // then
        assertThat(result.getContent()).hasSize(2);
        assertThat(result.getContent().get(0).title()).isEqualTo("post1");
        assertThat(result.getContent().get(0).author()).isEqualTo("test1");
    }
}
