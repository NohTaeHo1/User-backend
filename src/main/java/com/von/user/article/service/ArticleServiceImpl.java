package com.von.user.article.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.von.user.article.model.ArticleDto;
import com.von.user.article.repository.ArticleRepository;
import com.von.user.common.component.MessengerVo;
import com.von.user.common.component.PageRequestVo;
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
        entityToDto((repo.save(dtoToEntity(t))));
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
}