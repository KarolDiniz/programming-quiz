package com.example.quizprogramacao.model;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.MongoTemplate;

import java.util.ArrayList;
import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "_id")
@Document(collection = "games")
public class Game {

    private ObjectId _id;
    private String playerName;
    private String playerEmail;
    private int score;
    private int wrongAnswers;

    public Game(String user, String playerEmail,int score,int wrongAnswers) {
        this.playerName = user;
        this.playerEmail = playerEmail;
        this.score = score;
        this.wrongAnswers = wrongAnswers;
    }
    private MongoTemplate mongoTemplate;
    public List<Game> returnGames(){
        Query query = new Query();
        query.with(Sort.by(Sort.Direction.ASC, "source"));
        List<Game> games = mongoTemplate.find(query, Game.class);
        return games;
    }
}