package com.skills.hub.service;

import com.skills.hub.model.User;
import com.skills.hub.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    // Register new user
    @Override
    public User registerUser(User user) {
        return userRepository.save(user);
    }

    // Login user
    @Override
    public User login(String email, String password) {
        return userRepository.findByEmailAndPassword(email, password);
    }
}
