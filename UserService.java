package com.jobportal.jobportal_backend.service;

import com.jobportal.jobportal_backend.entity.User;
import com.jobportal.jobportal_backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User save(User user) {
        return repo.save(user);
    }

    // ⭐ ADD LOGIN METHOD HERE
    public User login(String email, String password) {

        User user = repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found"));

        if (!user.getPassword().equals(password)) {
            throw new RuntimeException("Invalid password");
        }

        return user;
    }

    public List<User> getAll() {
        return repo.findAll();
    }
}

