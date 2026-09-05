package com.jobportal.jobportal_backend.controller;

import com.jobportal.jobportal_backend.DTO.LoginRequest;
import com.jobportal.jobportal_backend.entity.User;
import com.jobportal.jobportal_backend.service.UserService;
import com.jobportal.jobportal_backend.config.JwtUtil;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@CrossOrigin
public class AuthController {

    private final UserService service;
    private final JwtUtil jwtUtil;

    public AuthController(UserService service, JwtUtil jwtUtil) {
        this.service = service;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/register")
    public User register(@RequestBody User user) {
        return service.save(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginRequest request) {

        User user =
            service.login(request.getEmail(), request.getPassword());

        // generate JWT using user's email
        return jwtUtil.generateToken(user.getEmail());
    }
}