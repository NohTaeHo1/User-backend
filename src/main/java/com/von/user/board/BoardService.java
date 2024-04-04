package com.von.user.board;

import com.von.user.article.Article;
import com.von.user.article.ArticleDto;
import com.von.user.common.command.CommandService;
import com.von.user.common.query.QueryService;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface BoardService extends CommandService, QueryService {

    default Board dtoToEntity(BoardDto dto) {
        Board board = Board.builder()
                .boardName(dto.getBoardName())
                .build();

        //boardId로 DB를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우

        return board;

    }

    default BoardDto entityToDto(Board board) {
        BoardDto dto = BoardDto.builder()
                .id(board.getId())
                .build();
        return dto;

    }


    List<?> readArticles() throws SQLException;

}
