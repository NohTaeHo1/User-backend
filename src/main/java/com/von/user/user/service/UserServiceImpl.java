package com.von.user.user.service;


import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.von.user.common.component.MessengerVo;
import com.von.user.user.model.UserDto;
import com.von.user.user.model.User;
import com.von.user.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("rawtypes")
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    @Override
    public MessengerVo save(UserDto t) {
        repo.save(dtoToEntity(t));
        return new MessengerVo();
    }

    @Override
    public MessengerVo modify(UserDto user) {
        repo.save(dtoToEntity(user));
        Long id = user.getId();
        return MessengerVo.builder()
                .message((repo.findById(id).isPresent())? "success":"failure")
                .build();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        repo.deleteById(id);
        return MessengerVo.builder()
                .message((repo.findById(id).isPresent())? "success":"failure")
                .build();
//        return MessengerVo.builder()
//                .message(
//                        Stream.of(id)
//                                .filter(i -> existsById(i))
//                                .peek(i -> repo.deleteById(i))
//                                .map(i -> "SUCCESS")
//                                .findAny()
//                                .orElseGet(() -> "FAILURE")
//                ).build();
    }

    @Override
    public List<UserDto> findAll() {
        return repo.findAll().stream().map(i -> entityToDto(i)).toList();
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return repo.findById(id).map(i -> entityToDto(i));
    }

    @Override
    public long count() {
        return repo.count();
    }

    @Override
    public boolean existsById(Long id) {
        return repo.existsById(id);
    }

    @Override
    public List<UserDto> findUsersByName(String name) {
        List<User> findAll = repo.findAll();
        Long id = 0L;
        for (int i = 0; i < findAll.size(); i++) {
            if (findAll.get(i).getName().equals("name")) {
                id = findAll.get(i).getId();
                break;
            } else if (i == findAll.size() - 1) {
            }
            ;
        }
        return repo.findAll().stream()
                .filter(user -> user.getName().equals(name))
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findUsersByJob'");
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Override
    public MessengerVo login(UserDto param) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'login'");
    }

}
