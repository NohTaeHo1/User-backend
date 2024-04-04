package com.von.user.user;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.von.user.common.component.MessengerVo;

import lombok.RequiredArgsConstructor;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserRepository repo;
    private final UserServiceImpl service;

    @PostMapping("/api/login") 
    public Map<String,?> login(@RequestBody Map<?,?> paramMap){
        Map<String, MessengerVo> map = new HashMap<>();
        String username = (String) paramMap.get("userName");
        String password = (String) paramMap.get("password");
        User optUser = repo.findByUsername(username).orElse(null); // Entity, Optinal, List 세가지 타입만 가능 / 엔티티는 널값 때문에 최대한 쓰지말자!.orElse쓰거나

        return map;
    }

    @GetMapping("/api/all-users")
    public List<User> findAll(){
        return repo.findAll();
    }

    @PostMapping(path = "/api/users")
    public Map<?,?> join(@RequestBody Map<String,?> paramMap){

        User newUser = repo.save(User.builder()
        .username((String) paramMap.get("userName"))
        .password((String) paramMap.get("password"))
        .name((String) paramMap.get("name"))
        .phone((String) paramMap.get("phone"))
        .job((String) paramMap.get("job"))
        .build()
        );
        System.out.println("DB에 저장된 User 정보: "+newUser);

        Map<String, String> map = new HashMap<>();
        map.put("a", "b");
        return map;
    }

    
    
    public Map<String, ?> findById(Scanner scanner) {
        Map<String, String> map = new HashMap<>();
        return map;    }
    
    public Map<String, ?> updatePassword(Scanner scanner) {
        Map<String, String> map = new HashMap<>();
        return map;
    }
    
    public Map<String, ?> delete(Scanner scanner) {
        Map<String, String> map = new HashMap<>();
        return map;
    }
    
    
    public Map<String, ?> findUsersByName(Scanner scanner) {
        Map<String, String> map = new HashMap<>();
        return map;    }
    
    
    public Map<String, ?> findUsersByJob(Scanner scanner) {
        Map<String, String> map = new HashMap<>();
        return map;    }
    
    
    public Map<String, ?> count() {
        Map<String, String> map = new HashMap<>();
        return map;    }
    
    
    public Map<String, ?> findUsers() throws SQLException {
        Map<String, String> map = new HashMap<>();
        return map;    }
    
    public Map<String, ?> createUsers() throws SQLException {
        Map<String, String> map = new HashMap<>();
        return map;    }
    
    public Map<String, ?> createTable() throws SQLException {
        Map<String, String> map = new HashMap<>();
        return map;    }
    
    public Map<String, ?> deleteTable() throws SQLException {
        Map<String, String> map = new HashMap<>();
        return map;    


}

}
