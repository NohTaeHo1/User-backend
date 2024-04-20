package com.von.user.user.repository;

import java.util.List;
import java.util.Optional;

import com.von.user.article.model.Article;
import com.von.user.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long>{
    Optional<User> findByUsername(String username);

    @Modifying // DB상태변화 시킬 때
    //@Query("update a.token from users a where a.token = :token")
    @Query("update users a set a.token = :token where a.id = :id")
    void modifyUserById(@Param("token") String token, @Param("id") Long id);

    @Query("select count(id) as count from users where username = :username")
    Integer getCount(@Param("username") String username);
    //count(*) 모든 columns를 다 체크하면서 셈 -> count(id) 는 id column만...
}