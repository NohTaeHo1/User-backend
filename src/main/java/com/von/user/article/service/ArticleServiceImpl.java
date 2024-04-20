package com.von.user.article.service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import com.von.user.article.model.ArticleDto;
import com.von.user.article.repository.ArticleRepository;
import com.von.user.board.model.BoardDto;
import com.von.user.common.component.MessengerVo;
import com.von.user.user.model.UserDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Slf4j
@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repo;

    @Override
    public MessengerVo save(ArticleDto t) {
        repo.save(dtoToEntity(t));
        return new MessengerVo();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        repo.deleteById(id);
        return new MessengerVo();
    }

    @Override
    public MessengerVo modify(ArticleDto articleDto) {
        return null;
    }



    @Override
    public List<ArticleDto> findAll() {
        return repo.findAll().stream().map(i->entityToDto(i)).toList();
    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
        return repo.findById(id).map(i->entityToDto(i));
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public List<ArticleDto> findArticleById(Long id) {
        return repo.getArticlesByBoardId(id).stream().map(i->entityToDto(i)).toList();
    }

//    @Override
//    public List<ArticleDto> findArticleById(Long id) {
//        return repo.findAll().stream().filter(i->i.getBoard().getId().equals(id)).map(i->entityToDto(i)).toList();
//    }

//    @Override
//    public List<ArticleDto> findAllById(Long id) {
//        return repo.getArticlesByBoardId(id).stream().map(i->entityToDto(i)).toList();
//    }


}