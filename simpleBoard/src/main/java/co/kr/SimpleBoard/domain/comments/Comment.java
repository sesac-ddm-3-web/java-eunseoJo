package co.kr.SimpleBoard.domain.comments;

import co.kr.SimpleBoard.domain.board.Board;
import co.kr.SimpleBoard.domain.user.User;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@Table(name="comments")

public class Comment {
    // 내용, 작성자, 작성일시
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;

    @Column(nullable = false)
    private String content;

    @CreationTimestamp
    private LocalDateTime commentDate;

    // 게시글
    @Setter
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "board_id")
    private Board board;

    // 작성자
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @Builder
    public Comment(String content, Board board, User user) {
        this.content = content;
        this.user = user;
        // 생성 시점에 Board와의 관계 설정
        if (board != null) {
            setBoard(board);
        }
    }



}
