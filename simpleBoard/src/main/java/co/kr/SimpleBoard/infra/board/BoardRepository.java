package co.kr.SimpleBoard.infra.board;

import co.kr.SimpleBoard.domain.board.Board;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BoardRepository extends JpaRepository<Board, Long> {
    Optional<Board>findByBoardId(Long id);
}
