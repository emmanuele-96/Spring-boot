package com.example.demo_UnitTest.controllers;

import com.example.demo_UnitTest.entities.User;
import com.example.demo_UnitTest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserRepository userRepository;
    @PostMapping("")
    public @ResponseBody User create(@RequestBody User user) {
        return userRepository.save(user);

    }
    @GetMapping("/")
    public @ResponseBody List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/{id}")
    public @ResponseBody User getUserById(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if(user.isPresent()) {
            return user.get();
        } else {
            return null;
        }
    }
    @PutMapping("/{id}/")
    public ResponseEntity<User> updateUser(@PathVariable Long id, @RequestBody User userDettails) {
        Optional<User> userOptional = userRepository.findById(id);
        if(userOptional.isPresent()) {
            User user = userOptional.get();
            user.setName(userDettails.getName());
            user.setSurname(userDettails.getSurname());
            user.setFiscalCode(userDettails.getFiscalCode());
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        userRepository.deleteById(id);
    }
}
