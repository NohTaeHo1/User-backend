package com.von.user.board.service;

import com.von.user.article.model.ArticleDto;
import com.von.user.board.model.Board;
import com.von.user.board.model.BoardDto;
import com.von.user.common.component.MessengerVo;
import com.von.user.common.service.CommandService;
import com.von.user.common.service.QueryService;
import com.von.user.user.model.UserDto;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

public interface BoardService extends CommandService<BoardDto>, QueryService<BoardDto> {


    default Board dtoToEntity(BoardDto dto) {
        Board board = Board.builder()
                .id(dto.getId())
                .description(dto.getDescription())
                .title(dto.getTitle())
                .build();

        //boardId로 DB를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우

        return board;

    }

    default BoardDto entityToDto(Board board) {
        return BoardDto.builder()
                .id(board.getId())
                .title(board.getTitle())
                .description(board.getDescription())
                .build();

    }

}
