package com.von.user.article;

import com.von.user.board.Board;
import com.von.user.common.BaseEntity;
import com.von.user.user.User;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity(name="articles")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
public class Article extends BaseEntity {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User writer;

    private String title;
    private String content;

    @Column(name = "regiter_date")
    private String registerDate;

    @Builder(builderMethodName = "builder")
    public Article(Long id, User user, Board board, String title, String content, User writer, String registerDate) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.registerDate = registerDate;
        this.writer = writer;
        this.board = board;
    }
}