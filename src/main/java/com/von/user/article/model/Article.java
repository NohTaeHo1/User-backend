package com.von.user.article.model;

import com.von.user.board.model.Board;
import com.von.user.common.model.BaseEntity;
import com.von.user.user.model.User;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.*;
import lombok.extern.log4j.Log4j2;


@Log4j2
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@ToString(exclude = {"id"})
@Entity(name = "articles")
@Builder
public class Article extends BaseEntity{

    @Id
    @Column(name ="id", nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String content;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer", nullable = true)
    private User writer;

    @ManyToOne
    @JoinColumn(name = "board", nullable = true)
    private Board board;
}