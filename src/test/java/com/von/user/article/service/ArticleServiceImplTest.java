package com.von.user.article.service;

import com.von.user.article.model.Article;
import com.von.user.article.model.ArticleDto;
import com.von.user.article.repository.ArticleRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class ArticleServiceImplTest {

    private ArticleService service;
    private static Article testArticle;
    @Mock
    private ArticleRepository repo;

    @BeforeEach
    void setup() {
        this.service = new ArticleServiceImpl(repo);
    }

    @BeforeEach
    void init(){
        testArticle = Article.of("테스트제목", "테스트글");
    }

//    @Test
//    public void 게시글_제목_검색()throws Exception{
//        //Given
//        repo.save(testArticle);
//
//        //When
//        Article article = repo.findById(1L).get();
//
//        //Then
//        assertThat(article.getTitle()).isEqualTo("테스트제목");
//    }
    @Test
    public void 게시글_전체_검색()throws Exception{
        List<Article> articles = getList();
        BDDMockito.given(repo.findAll()).willReturn(articles);
        List<ArticleDto> list = service.findAll();
        assertThat(list.size())
                .isEqualTo(3);
    }


    private List<Article> getList() {
        return Arrays.asList(
                Article.builder().id(12L).title("내가").content("매화").build(),
                Article.builder().id(23L).title("너에게").content("벚꽃").build(),
                Article.builder().id(34L).title("가겠다").content("여름").build()
        );
    }

    @Test
    void save() {
    }

    @Test
    void deleteById() {
    }

    @Test
    void modify() {
    }

    @Test
    void findAll() {
    }

    @Test
    void findById() {
    }

    @Test
    void count() {
    }

    @Test
    void existsById() {
    }
}