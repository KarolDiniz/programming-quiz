package com.example.quizprogramacao.controller;

import com.example.quizprogramacao.model.Game;
import com.example.quizprogramacao.repository.GameRepository;
import com.example.quizprogramacao.repository.QuestionRepository;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/game")
public class GameController {

    @Autowired
    private GameRepository gameRepository = new GameRepository();

    @PostMapping("/create")
    public InsertOneResult addGame(@RequestBody Game game) {
        return gameRepository.addGame(game);
    }

    @GetMapping("/return")
    public List<Game> returnGames() {
        return gameRepository.getAllGames();
    }
}
