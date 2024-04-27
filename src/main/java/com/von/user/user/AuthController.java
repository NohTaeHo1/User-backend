package com.von.user.user;

import com.von.user.common.component.MessengerVo;
import com.von.user.user.model.UserDto;
import com.von.user.user.service.UserServiceImpl;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@ApiResponses(value = {
        @ApiResponse(responseCode = "400", description = "Invalid ID supplied"),
        @ApiResponse(responseCode = "404", description = "Customer not found")})
@RestController
@RequiredArgsConstructor
@RequestMapping(path = "api/auth")
@Slf4j
public class AuthController {
    private final UserServiceImpl service;

    @PostMapping(path = "/login")
    public ResponseEntity<MessengerVo> login(@RequestBody UserDto param) {
        log.info("입력받은 정보 : {}", param );
        return ResponseEntity.ok(service.login(param));
    }

    @GetMapping(path = "/exist-username")
    public ResponseEntity<Boolean> existByUsername(@RequestParam("username") String username){
        log.info("existByUsername : "+username);
        return ResponseEntity.ok(service.existsByUsername(username));
    }
}
