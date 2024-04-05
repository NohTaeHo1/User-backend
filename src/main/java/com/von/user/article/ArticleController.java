package com.von.user.article;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.von.user.article.model.Article;
import com.von.user.article.service.ArticleServiceImpl;
import com.von.user.common.component.MessengerVo;
import com.von.user.common.component.PageRequestVo;
import com.von.user.common.model.BaseEntity;
import com.von.user.user.model.UserDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping(path = "")
    public ResponseEntity<MessengerVo> save(PageRequestVo vo) {
        service.save(null);
        //User newUser = service.save(param);
        return ResponseEntity.ok(new MessengerVo());
    }
}