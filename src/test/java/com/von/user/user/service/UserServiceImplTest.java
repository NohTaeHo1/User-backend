package com.von.user.user.service;

import com.von.user.common.component.MessengerVo;
import com.von.user.user.model.UserDto;
//import jakarta.transaction.Transactional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class UserServiceImplTest {

    @Autowired
    UserServiceImpl service ;

    @Test
    @Transactional
    @DisplayName("가입한 회원 수")
    void count() {
        assertThat(service.count()).withFailMessage("가입한 회원 수가 예상과 다릅니다.").isEqualTo(1);
    }

    @Test
    @Transactional
    @DisplayName("새로운 사용자 저장")
    void save() {
        UserDto userDto = UserDto.builder()
                .username("홍길동")
                .build();

        MessengerVo messenger = service.save(userDto);

        assertThat(messenger).isNotNull();
        //assertThat(messenger).isEqualTo("성공");
        //assertThat(messenger).isEqualTo("실패");
    }

    @Test
    @Transactional
    @DisplayName("모든 사용자 조회")
    void findAll() {
        List<UserDto> users = service.findAll();
        assertThat(users).isNotEmpty();
    }

//    @Test
//    @Transactional
//    @DisplayName("ID로 사용자 조회")
//    void findById() {
//        UserDto userDto = UserDto.builder()
//                .username("홍길동")
//                .build();
//        service.save(userDto);
//        List<UserDto> userDtoList = service.findUsersByName("홍길동");
//        User user = User.builder()
//                .id(userDtoList.getId())
//                .phone(dto.getPhone())
//                .name(dto.getName())
//                .password(dto.getPassword())
//                .username(dto.getUsername())
//                .job(dto.getJob())
//                .build();
//
//
//        Optional<UserDto> foundUser = service.findById(userId);
//
//        assertThat(foundUser).isPresent();
//        assertThat(foundUser.get().getId()).isEqualTo(userId);
//    }

    @Test
    @Transactional
    @DisplayName("ID로 사용자 삭제")
    void deleteUserById() {
        UserDto userDto = UserDto.builder()
                .username("홍길동")
                .build();
        service.save(userDto);
        service.findUsersByName("홍길동");
        Long userId = userDto.getId();
        Optional<UserDto> foundUser = service.findById(userId);
        assertThat(foundUser).isEmpty();
    }
}