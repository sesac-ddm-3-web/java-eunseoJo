package co.kr.SimpleBoard;

import co.kr.SimpleBoard.infra.board.BoardRepository;
import co.kr.SimpleBoard.infra.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import co.kr.SimpleBoard.domain.user.User;
import co.kr.SimpleBoard.domain.board.Board;

import java.util.List;

@Component
@RequiredArgsConstructor
public class DataInit implements CommandLineRunner {

    private final UserRepository userRepository;
    private final BoardRepository boardRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public void run(String args[]) throws Exception {

        System.out.println("====== 기존 데이터 삭제 시작 ======");
        // 1. 자식 테이블(Board) 먼저 삭제 (안 그러면 User 지울 때 에러 남)
        boardRepository.deleteAll();

        // 2. 부모 테이블(User) 삭제
        userRepository.deleteAll();
        System.out.println("====== 기존 데이터 삭제 완료 ======");


        // 3. 다시 데이터 채워넣기 (기존 코드)
        User u1 = User.builder().username("user1").password(passwordEncoder.encode("1234")).build();
        User u2 = User.builder().username("user2").password(passwordEncoder.encode("1234")).build();

        userRepository.saveAll(List.of(u1, u2));

        for (int i = 1; i <= 20; i++) {
            User author = (i % 2 == 0) ? u2 : u1;
            Board board = Board.builder()
                    .title("Title " + i)
                    .content("Short content " + i)
                    .user(author)
                    .build();
            boardRepository.save(board);
        }

        System.out.println("====== 테스트 데이터 20개 새로 생성 완료 ======");
    }
}