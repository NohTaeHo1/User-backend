package com.von.user.article;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.von.user.common.BaseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.von.user.common.component.MessengerVo;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class ArticleController extends BaseEntity {

    private final ArticleServiceImpl service;

    @SuppressWarnings("unchecked")
    @GetMapping("/api/all-articles")
    public Map<?,?> findAll() throws SQLException {
        Map<String, Object> map = new HashMap<>();
        
        List<Article> list = new ArrayList<>();
        // list.add(Article.builder().
        // id(1L)
        // .title("글제목")
        // .content("내용")
        // .writer("작가")
        // .registerDate("2024-03")
        // .build());

        return map;
    }
}