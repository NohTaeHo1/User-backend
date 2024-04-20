package com.von.user.user.service;


import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.von.user.common.component.JwtProvider;
import com.von.user.common.component.MessengerVo;
import com.von.user.user.model.UserDto;
import com.von.user.user.model.User;
import com.von.user.user.repository.UserRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

@SuppressWarnings("rawtypes")
@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository repo;

    private final JwtProvider jwtProvider;

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
                .message((repo.findById(id).isPresent()) ? "success" : "failure")
                .build();
    }

    @Override
    public MessengerVo deleteById(Long id) {
        repo.deleteById(id);
        return MessengerVo.builder()
                .message((repo.findById(id).isPresent()) ? "failure" : "success")
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

        return repo.findAll().stream()
                .filter(user -> user.getName().equals(name))
                .map(this::entityToDto)
                .collect(Collectors.toList());
    }

    @Override
    public List<UserDto> findUsersByJob(String job) {

        return repo.findAll().stream()
                .filter(i -> i.getJob().equals(job))
                .map(i -> entityToDto(i))
                .collect(Collectors.toList());
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return repo.findByUsername(username);
    }

    @Transactional
    @Override
    public MessengerVo login(UserDto dto) {
        User user = repo.findByUsername(dto.getUsername()).get();
        String token = jwtProvider.createToken(entityToDto(user));
        boolean flag = user.getPassword().equals(dto.getPassword());

        //repo.modifyUserById(dto.getToken(), user.getId());

        //토큰을 각 섹션(Header, Payload, Signature)으로 분할
        String[] chunks = token.split("\\.");

        Base64.Decoder decoder = Base64.getUrlDecoder();

        String header = new String(decoder.decode(chunks[0]));
        String payload = new String(decoder.decode(chunks[1]));

        log.info("Token Header : " + header);
        log.info("Token Payload : " + payload);

        return MessengerVo.builder()
                .message(flag ? "SUCCESS" : "FAILURE")
                .token(flag ? jwtProvider.createToken(dto) : "None")
                .build();
    }

//    @Override
//    public MessengerVo login(UserDto dto) {
//        return MessengerVo.builder()
//                .message(findUserByUsername(dto.getUsername()).get().getPassword().equals(dto.getPassword())? "SUCCESS": "FAILURE")
//                .token(flag? jwtProvider.createToken(dto) :"None" )
//                .build();
//    }
//    @Override
//    public MessengerVo login(UserDto param) {
//        return MessengerVo.builder()
//                .message(repo.findAll().stream()
//                        .filter(i->i.getUsername().equals(param.getUsername()))
//                        .filter(i->i.getPassword().equals(param.getPassword()))
//                        .map(i->"성공")
//                        .findAny().orElse("실패"))
//                .build();
//    }

    @Override
    public boolean existsByUsername(String username) {
        int count = repo.getCount(username);
        return (count == 1) ? true : false;
        //(count == 1) ? true : false; 여기서 뒤에 true:false; 생략가능
    }

}
