package com.example.quizprogramacao.model;


import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "questions")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "_id")
public class Question {

    @Id
    private ObjectId _id;

    private String pergunta;

    private List<String> opcoes;

    private int resposta;


    public boolean equals(Question question){
        return resposta == question.resposta;
    }
}
