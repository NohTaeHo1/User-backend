package com.von.user.board.service;


import com.von.user.board.model.BoardDto;
import com.von.user.board.repository.BoardRepository;
import com.von.user.common.component.MessengerVo;
import com.von.user.common.component.PageRequestVo;
import com.von.user.user.model.UserDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository repo;


    @Override
    public MessengerVo save(BoardDto t) {
        entityToDto((repo.save(dtoToEntity(t))));
        return new MessengerVo();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        repo.deleteById(id);
        return new MessengerVo();    }

    @Override
    public MessengerVo modify(BoardDto boardDto) {
        return null;
    }

    @Override
    public List<BoardDto> findAll() {
        return repo.findAll().stream().map(i->entityToDto(i)).toList();
        }


    @Override
    public Optional<BoardDto> findById(Long id) {
        return repo.findById(id).map(i->entityToDto(i));
    }

    @Override
    public long count() {
        return repo.count();    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }
}
