package com.example.quizprogramacao.question;

import org.bson.Document;
import org.bson.types.ObjectId;

public class DocumentMapper {

    public static Question map(Document document) {

        Question question = new Question();

        question.set_id(document.getObjectId("_id"));
        question.setPergunta(document.getString("pergunta"));
        question.setResposta(document.getInteger("resposta"));
        question.setOpcoes(document.getList("opcoes", String.class));
        return question;
    }
}
