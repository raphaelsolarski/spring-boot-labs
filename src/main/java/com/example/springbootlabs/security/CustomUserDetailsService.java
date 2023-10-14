package com.example.springbootlabs.security;

import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.HashMap;
import java.util.Map;

public class CustomUserDetailsService implements UserDetailsService {
    private final Map<String, CustomUser> users = new HashMap<>();

    public CustomUserDetailsService() {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

        CustomUser user = new CustomUser(User.builder()
                .username("user")
                .passwordEncoder(passwordEncoder::encode)
                .password("password")
                .roles("USER")
                .build(), 20);

        users.put(user.getUsername(), user);

        CustomUser admin = new CustomUser(User.builder()
                .username("admin")
                .passwordEncoder(passwordEncoder::encode)
                .password("password")
                .roles("ADMIN")
                .build(), 100);

        users.put(admin.getUsername(), admin);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        CustomUser user = this.users.get(username.toLowerCase());
        if (user == null) {
            throw new UsernameNotFoundException(username);
        } else {
            return new CustomUser(user, user.getAge());
        }
    }
}
