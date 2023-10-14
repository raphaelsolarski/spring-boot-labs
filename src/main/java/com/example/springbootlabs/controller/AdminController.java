package com.example.springbootlabs.controller;

import com.example.springbootlabs.security.CustomUser;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/admin")
public class AdminController {
    @GetMapping
    public String get(@AuthenticationPrincipal CustomUser user) {
        return user.getUsername();
    }
}
