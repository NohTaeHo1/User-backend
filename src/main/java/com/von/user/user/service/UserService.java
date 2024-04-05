package com.von.user.user.service;

import java.util.List;
import java.util.Optional;

import com.von.user.common.service.CommandService;
import com.von.user.common.service.QueryService;
import com.von.user.user.model.User;
import com.von.user.user.model.UserDto;

public interface UserService extends CommandService<UserDto>, QueryService<UserDto> {

    default User dtoToEntity(UserDto dto) {
        User user = User.builder()
                .job(dto.getJob())
                .build();

        //boardId로 DB를 조회해서 해당 게시판에 게시된 글의 목록을 가져올 경우

        return user;

    }

    default UserDto entityToDto(Optional<User> opt) {
        UserDto dto = UserDto.builder().build();
        return dto;

    }

}
