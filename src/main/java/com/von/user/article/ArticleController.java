package com.von.user.article;

import java.sql.SQLException;
import java.util.*;

import com.von.user.article.model.Article;
import com.von.user.article.model.ArticleDto;
import com.von.user.article.service.ArticleServiceImpl;
import com.von.user.common.component.MessengerVo;
import com.von.user.common.component.PageRequestVo;
import com.von.user.common.model.BaseEntity;
import com.von.user.user.model.UserDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RequestMapping("api/articles")
@Slf4j
public class ArticleController extends BaseEntity {

    private final ArticleServiceImpl service;

    @PostMapping("/save")
    public ResponseEntity<MessengerVo> save(@RequestBody ArticleDto dto){
        log.info("입력받은 정보 : {}", dto );
        return ResponseEntity.ok(service.save(dto));
    }
    @DeleteMapping("/delete")
    public ResponseEntity<MessengerVo> deleteById(@RequestParam("id") Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.deleteById(id));
    }
    @GetMapping("/list")
    public ResponseEntity<List<ArticleDto>> findByBoardId(){
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/detail/")
    public ResponseEntity<Optional<ArticleDto>> findById(@RequestParam("id") Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }
    @GetMapping("/count")
    public ResponseEntity<Long> count(PageRequestVo vo) throws SQLException {
        return ResponseEntity.ok(service.count());
    }
    @GetMapping("/exists/{id}")
    public ResponseEntity<MessengerVo> existsById(@PathVariable long id) throws SQLException {
        service.existsById(0L);
        return ResponseEntity.ok(new MessengerVo());
    }

    @GetMapping("/detail/{id}")
    public List<ArticleDto> findArticleById(@PathVariable long id) {
        return service.findArticleById(id);
    }


}