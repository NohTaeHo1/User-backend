package com.von.user.article.service;


import com.von.user.article.model.Article;
import com.von.user.article.model.ArticleDto;
import com.von.user.common.service.CommandService;
import com.von.user.common.service.QueryService;

import java.util.Optional;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {
    default Article dtoToEntity(ArticleDto dto) {
        Article article = Article.builder()
                .title(dto.getTitle())
                .build();

        //boardId로 DB를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우

        return article;

    }

    default ArticleDto entityToDto(Optional<Article> opt) {
        ArticleDto dto = ArticleDto.builder().build();

        return dto;
    }
}
