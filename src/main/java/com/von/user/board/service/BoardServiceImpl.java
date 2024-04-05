package com.von.user.board.service;


import com.von.user.board.model.BoardDto;
import com.von.user.board.repository.BoardRepository;
import com.von.user.common.component.PageRequestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private BoardRepository repo;

    @Override
    public BoardDto save(BoardDto t) {
        return entityToDto(Optional.of(repo.save(dtoToEntity(t))));
    }


    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<BoardDto> findAll(PageRequestVo vo) {
        //return repo.findAll(vo);
        return null;
    }

    @Override
    public Optional<BoardDto> findById(Long id) {
        return Optional.of(entityToDto(repo.findById(id)));
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }
}
