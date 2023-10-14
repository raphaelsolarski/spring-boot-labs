package com.example.springbootlabs.controller;

import com.example.springbootlabs.security.CustomUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {
    @GetMapping("/age")
    public String getAge(@AuthenticationPrincipal CustomUser user) {
        return String.valueOf(user.getAge());
    }
}
