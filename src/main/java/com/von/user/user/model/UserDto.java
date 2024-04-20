package com.von.user.user.model;
import com.von.user.article.model.Article;
import org.springframework.stereotype.Component;
import lombok.*;

import java.util.List;

@Component
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {

    private Long id;
    private String username;
    private String password;
    private String email;
    private String name;
    private String phone;
    private String job;
    private String regDate;
    private String modDate;
    private String token;

}