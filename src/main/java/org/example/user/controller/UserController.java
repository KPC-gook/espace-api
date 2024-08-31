package org.example.user.controller;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;
import com.google.firebase.auth.FirebaseToken;
import com.google.firebase.auth.UserRecord;
import org.example.user.domain.User;
import org.example.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping("/{uid}")
    public User getUserById(@PathVariable String uid) {
        return userService.getUserById(uid);
    }

    @GetMapping("/token/{idToken}")
    public User getUserByToken(@PathVariable String idToken) throws FirebaseAuthException {
        FirebaseToken decodedToken = FirebaseAuth.getInstance().verifyIdToken(idToken);
        String uid = decodedToken.getUid();

        return userService.getUserById(uid);
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        return userService.createUser(user);
    }

    @PutMapping("/{uid}")
    public User updateUser(@PathVariable String uid, @RequestBody User user) {
        return userService.updateUser(uid, user);
    }

    @DeleteMapping("/{uid}")
    public void deleteUser(@PathVariable String uid) {
        userService.deleteUser(uid);
    }
}