package com.von.user.board;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class BoardController {
        BoardService bs;



    public List<?> readArticles() throws SQLException {
        return null;
    }
}
