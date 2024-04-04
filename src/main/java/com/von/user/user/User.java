package com.von.user.user;
import java.util.List;

import com.von.user.article.Article;
import com.von.user.common.BaseEntity;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.*;


@NoArgsConstructor (access = AccessLevel.PROTECTED)
@Getter
@ToString
@Entity(name = "users")
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)    
    private Long id;

    @OneToMany(mappedBy = "writer")
    private List<Article> article;
    
    private String username;
    private String password;
    private String name;
    private String phone;
    private Long addressId;
    private String job;

    @Builder(builderMethodName = "builder")
    public User(Long id, String username, String password, String name, String phone, String job) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.phone = phone;
        this.job = job;
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}