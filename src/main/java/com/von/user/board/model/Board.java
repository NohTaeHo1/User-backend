package com.von.user.board.model;


import java.util.List;

import com.von.user.common.model.BaseEntity;

import com.von.user.article.model.Article;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;


@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(exclude = {"id"})
@Entity
public class Board extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @OneToMany(mappedBy = "board")
    private List<Article> articles;

    private String boardName;
    private String boardType;    

    @Builder(builderMethodName = "builder")
    public Board(Long id, List<Article> articles, String boardName, String boardType) {
        this.id = id;
        this.boardName = boardName;
        this.boardType = boardType;
        this.articles = articles;
    }

}