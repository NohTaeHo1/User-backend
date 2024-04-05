package com.von.user.user;

import java.sql.SQLException;
import java.util.*;

import com.von.user.user.model.User;
import com.von.user.user.model.UserDto;
import com.von.user.user.repository.UserRepository;
import com.von.user.user.service.UserServiceImpl;
import com.von.user.common.component.MessengerVo;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springdoc.core.converters.models.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.*;


import lombok.RequiredArgsConstructor;

//@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/users")
@Slf4j
public class UserController {
    private final UserRepository repo;
    private final UserServiceImpl service;

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @PostMapping(path = "")
    public ResponseEntity<MessengerVo> save(@RequestBody Map<String, UserDto> param) {
        log.info("입력받은 정보 : {}", param);
        //User newUser = service.save(param);
        return ResponseEntity.ok(new MessengerVo()); // .ok()는 200만 OK가 뜨는 메서드
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @PostMapping("/login")
    public ResponseEntity<MessengerVo> login(@RequestBody Map<?, ?> paramMap) {
        Map<String, MessengerVo> map = new HashMap<>();
        String username = (String) paramMap.get("userName");
        //User user = service.findByUsername(username).orElse(null); // Entity, Optinal, List 세가지 타입만 가능 / 엔티티는 널값 때문에 최대한 쓰지말자!.orElse쓰거나

        return ResponseEntity.ok(new MessengerVo());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @GetMapping("")
    public ResponseEntity<List<UserDto>> findAll(Pageable pageable) {
        return ResponseEntity.ok(new ArrayList<UserDto>());
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @PostMapping(path = "/api/users")
    public ResponseEntity<MessengerVo> join(@RequestBody Map<String, ?> paramMap) {

        User newUser = repo.save(User.builder()
                .username((String) paramMap.get("userName"))
                .password((String) paramMap.get("password"))
                .name((String) paramMap.get("name"))
                .phone((String) paramMap.get("phone"))
                .job((String) paramMap.get("job"))
                .build()
        );
        System.out.println("DB에 저장된 User 정보: " + newUser);

        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        return ResponseEntity.ok(new MessengerVo());
    }


    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})

    public Map<String, ?> findById(Scanner scanner) {
        Map<String, String> map = new HashMap<>();
        return map;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    public Map<String, ?> updatePassword(@RequestBody Map<?, ?> paramap) {
        Map<String, String> map = new HashMap<>();
        return map;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    public Map<String, ?> delete(Scanner scanner) {
        Map<String, String> map = new HashMap<>();
        return map;
    }

    @ApiResponses(value = {
            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
            @ApiResponse(responseCode = "404", description = "Customer not found")})
    @GetMapping("/{id}")
    public Map<String, ?> findUsersById(@PathVariable Long id) { //이때 id가 path의 {} 이름이 같아야함
        Map<String, String> response = new HashMap<>();
        return response;
    }

//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    public Map<String, ?> findUsersByJob(Scanner scanner) {
//        Map<String, String> map = new HashMap<>();
//        return map;
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    public Map<String, ?> count() {
//        Map<String, String> map = new HashMap<>();
//        return map;
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    public Map<String, ?> findUsers() throws SQLException {
//        Map<String, String> map = new HashMap<>();
//        return map;
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    public Map<String, ?> createUsers() throws SQLException {
//        Map<String, String> map = new HashMap<>();
//        return map;
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    public Map<String, ?> createTable() throws SQLException {
//        Map<String, String> map = new HashMap<>();
//        return map;
//    }
//
//    @ApiResponses(value = {
//            @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
//            @ApiResponse(responseCode = "404", description = "Customer not found")})
//    public Map<String, ?> deleteTable() throws SQLException {
//        Map<String, String> map = new HashMap<>();
//        return map;
//
//
//    }

}
