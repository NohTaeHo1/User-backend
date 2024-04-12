package com.von.user.board.model;


import java.util.List;

import com.von.user.common.model.BaseEntity;

import com.von.user.article.model.Article;

import jakarta.persistence.*;
import lombok.*;


@Entity(name="boards")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class Board extends BaseEntity{

    @Id
    @Column(name = "id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "board_name")
    private String boardName;
    private String boardType;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Article> articles;

}