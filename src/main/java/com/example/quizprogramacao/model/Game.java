package com.example.quizprogramacao.model;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.core.mapping.Document;

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

}