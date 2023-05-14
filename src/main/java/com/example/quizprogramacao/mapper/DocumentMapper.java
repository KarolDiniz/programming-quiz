package com.example.quizprogramacao.mapper;

import com.example.quizprogramacao.model.Question;
import com.example.quizprogramacao.model.User;
import org.bson.Document;

public class DocumentMapper {

    public static Question map(Document document) {

        Question question = new Question();
        question.set_id(document.getObjectId("_id"));
        question.setPergunta(document.getString("pergunta"));
        question.setResposta(document.getInteger("resposta"));
        question.setOpcoes(document.getList("opcoes", String.class));
        return question;
    }

    public static User mapUser(Document document) {

        User user = new User();
        user.set_id(document.getObjectId("_id"));

        return user;
    }
}
