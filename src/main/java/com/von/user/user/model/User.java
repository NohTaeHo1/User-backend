package com.von.user.user.model;
import java.util.List;

import com.von.user.article.model.Article;
import com.von.user.common.model.BaseEntity;
import jakarta.persistence.*;
import lombok.*;


@Entity(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Getter
@Builder
@ToString(exclude = { "id", "articles","token" })
public class User extends BaseEntity{

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String job;
    private String token;

    @OneToMany(mappedBy = "writer", cascade = CascadeType.REMOVE)
    private List<Article> articles;

    // @OneToMany(mappedBy = "user")
    // private List<Order> ordersId;

    public void setPassword(String password) {
        this.password = password;
    }
}