package com.von.user.board.repository;

import com.von.user.article.model.Article;
import com.von.user.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Repository
public interface BoardRepository  extends JpaRepository<Board, Long>{

    @Transactional(readOnly = true)
    List<Board> findAllByOrderByIdDesc();



}
