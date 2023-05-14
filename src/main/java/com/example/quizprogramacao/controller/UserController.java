package com.example.quizprogramacao.controller;

import com.example.quizprogramacao.model.User;
import com.example.quizprogramacao.repository.QuestionRepository;
import com.example.quizprogramacao.repository.UserRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserRepository userRepository = new UserRepository();

    @PostMapping("/create")
    public InsertOneResult addUser(@RequestBody User user) {
        return userRepository.addUser(user);
    }

    @DeleteMapping("/delete")
    public DeleteResult dropUser(String id) {
        return userRepository.deleteUser(id);
    }
}
