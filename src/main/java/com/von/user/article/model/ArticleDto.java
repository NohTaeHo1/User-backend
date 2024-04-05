package com.von.user.article.model;

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
    private String registerDate;

    private Long boardId;
    private Long writerId;
}
