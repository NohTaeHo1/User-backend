package com.von.user.article.service;

import java.util.List;
import java.util.Optional;

import com.von.user.article.model.ArticleDto;
import com.von.user.article.repository.ArticleRepository;
import com.von.user.common.component.PageRequestVo;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ArticleServiceImpl implements ArticleService {

    private final ArticleRepository repo;

    @Override
    public ArticleDto save(ArticleDto t) {
        return entityToDto(Optional.of(repo.save(dtoToEntity(t))));
    }

    @Override
    public void deleteById(Long id) {
        repo.deleteById(id);
    }

    @Override
    public List<ArticleDto> findAll(PageRequestVo vo) {
        //return repo.findAll(vo);
        return null;
    }

    @Override
    public Optional<ArticleDto> findById(Long id) {
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