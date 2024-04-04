package com.von.user.article;


import com.von.user.board.Board;
import com.von.user.board.BoardDto;
import com.von.user.common.command.CommandService;
import com.von.user.common.query.QueryService;

import java.util.Optional;

public interface ArticleService extends CommandService<ArticleDto>, QueryService<ArticleDto> {
    default Article dtoToEntity(ArticleDto dto) {
        Article article = Article.builder()
                .title(dto.getTitle())
                .build();

        //boardId로 DB를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우

        return article;

    }

    default Optional<ArticleDto> entityToDto(Article ent) {
        ArticleDto dto = ArticleDto.builder()

                .content(ent.getContent())
                .build();

        return Optional.of(dto);
    }
}
