package com.von.user.board;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl{

    public List<?> readArticles() throws SQLException {
        return null;
    }
}
