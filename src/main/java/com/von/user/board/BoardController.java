package com.von.user.board;

import com.von.user.article.model.ArticleDto;
import com.von.user.board.model.BoardDto;
import com.von.user.board.service.BoardService;
import com.von.user.board.service.BoardServiceImpl;
import com.von.user.user.model.UserDto;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/boards")
@Slf4j
public class BoardController {
        private final BoardServiceImpl service;

    @GetMapping("/list")
    public ResponseEntity<List<BoardDto>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/detail")
    public ResponseEntity<Optional<BoardDto>> findById(@RequestParam Long id) {
        log.info("입력받은 정보 : {}", id );
        return ResponseEntity.ok(service.findById(id));
    }

    public List<?> readArticles() throws SQLException {
        return null;
    }
}
