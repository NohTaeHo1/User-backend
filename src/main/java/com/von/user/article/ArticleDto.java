package com.von.user.article;

import com.von.user.board.Board;
import com.von.user.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.springframework.stereotype.Component;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@Log4j
public class ArticleDto {

    private Long id;
    private String title;
    private String content;
    private String registerDate;

    private Long boardId;
    private Long writerId;
}
