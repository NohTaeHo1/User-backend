package com.von.user.article.model;

import com.von.user.board.model.Board;
import com.von.user.user.model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
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
    private Long writerId;
    private Long boardId;
    private String regDate;
    private String modDate;
}
