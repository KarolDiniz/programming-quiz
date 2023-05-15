package com.example.quizprogramacao.mapper;

import com.example.quizprogramacao.model.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

public class ConvertObjectToDocument {

    @Autowired
    private MongoTemplate mongoTemplate;

    public Document convertObjectToDocument(User user) {

        Document document = new Document();
        document.append("name", user.getName());
        document.append("email", user.getEmail());
        mongoTemplate.insert(document, "users");

        return document;
    }
}
