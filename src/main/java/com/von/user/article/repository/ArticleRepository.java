package com.von.user.article.repository;


import com.von.user.article.model.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository<Article, Long>{

//    JPQL Default
    @Query("select a from articles a where a.board.id = :board")
    public List<Article> getArticlesByBoardId(@Param("board") Long boardId);

//    //JPQL Default
////    @Query(value = "select * from articles a where a.board.id = 1", nativeQuery = true)
////    public List<Article> getQnAArticles());
//
//    @Query("select id, title, content from articles where articles.board.id = :board")
//    public List<Article> getArticlesByBoardId(@Param("board") Long boardId);

}