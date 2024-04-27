package com.von.user.board.service;


import com.von.user.article.model.Article;
import com.von.user.board.model.Board;
import com.von.user.board.model.BoardDto;
import com.von.user.board.repository.BoardRepository;
import com.von.user.common.component.MessengerVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
    private final BoardRepository repo;

    @Override
    public MessengerVo save(BoardDto dto) {
        return MessengerVo.builder()
                .message((repo.save(dtoToEntity(dto)) instanceof Board)?"SUCESS":"FAILURE")
                .build();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        repo.deleteById(id);
        return MessengerVo.builder()
                .message((repo.findById(id).isEmpty())?"SUCCESS":"FAILURE")
                .build();
    }

    @Override
    public MessengerVo modify(BoardDto dto) {
        return MessengerVo.builder()
                .message((repo.save(dtoToEntity(dto)) instanceof Board)?"SUCESS":"FAILURE")
                .build();
    }

    @Override
    public List<BoardDto> findAll() {
        return repo.findAllByOrderByIdDesc().stream().map(i->entityToDto(i)).toList();
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
