package com.von.user.article.service;


import com.von.user.article.model.Article;
import com.von.user.article.model.ArticleDto;
import com.von.user.common.component.MessengerVo;
import com.von.user.common.service.CommandService;
import com.von.user.common.service.QueryService;
import com.von.user.user.model.User;
import com.von.user.user.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {
    MessengerVo modify(ArticleDto article);

    default Article dtoToEntity(ArticleDto dto) {
        Article article = Article.builder()
                .id(dto.getId())
                .content(dto.getContent())
                .title(dto.getTitle())
                .build();

        //boardId로 DB를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우

        return article;

    }

    default ArticleDto entityToDto(Article article) {
        return ArticleDto.builder()
                .content(article.getContent())
                .id(article.getId())
                .title(article.getTitle())
                .build();
    }
}
