package com.von.user.board.model;

import com.von.user.article.model.Article;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
//@Log4j
public class BoardDto {
    private Long id;
    private String boardName;
    private String boardType;
    //private List<Article> articles = new ArrayList<>();

}
