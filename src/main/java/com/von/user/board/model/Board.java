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
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String description;
    private String content;

    @OneToMany(mappedBy = "board", cascade = CascadeType.REMOVE, orphanRemoval = true)
    private List<Article> articles;

}