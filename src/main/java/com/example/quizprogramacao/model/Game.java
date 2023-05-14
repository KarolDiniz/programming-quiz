package com.example.quizprogramacao.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "_id")
@Document(collection = "Game")
public class Game {

    private String _id;
    private User playerName;
    private int score;
    private List<Question> questions;
    private int wrongAnswers;
    private int currentQuestionIndex;
    private boolean finished;

    public void play(User user, List<Question> questions){


    }

}
