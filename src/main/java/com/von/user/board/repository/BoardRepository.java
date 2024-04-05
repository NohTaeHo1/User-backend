package com.von.user.board.repository;

import com.von.user.board.model.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface BoardRepository  extends JpaRepository<Board, Long>{

}
