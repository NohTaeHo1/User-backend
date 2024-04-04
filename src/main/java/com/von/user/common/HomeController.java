package com.von.user.common;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequiredArgsConstructor
public class HomeController {

    @GetMapping("/")
    public String hello() {
        return "welcome to Spring boot";
    }

}