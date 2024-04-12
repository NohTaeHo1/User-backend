package com.von.user.article.repository;


import com.von.user.article.model.Article;
import com.von.user.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{


} 