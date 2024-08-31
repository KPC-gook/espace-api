package org.example.user.service;

import org.example.user.domain.User;
import org.example.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(String uid) {
        return userRepository.findById(uid).orElse(null);
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(String uid, User user) {
        User existingUser = userRepository.findById(uid).orElse(null);
        if (existingUser != null) {
//            existingUser.set(user.getTitle());
//            existingUser.setUrl(user.getUrl());
//            existingUser.setImage(user.getImage());
            return userRepository.save(existingUser);
        }
        return null;
    }

    public void deleteUser(String uid) {
        userRepository.deleteById(uid);
    }
}