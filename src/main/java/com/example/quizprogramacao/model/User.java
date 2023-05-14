package com.example.quizprogramacao.model;
import lombok.*;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "_id")
@Document(collection = "users")
public class User {

    @Id
    private ObjectId _id;
    private String name;
    private String email;
    private String password;
    private int score;
    private int changes;
}
