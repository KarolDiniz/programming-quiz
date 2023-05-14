package com.example.quizprogramacao.question;

import com.example.quizprogramacao.model.Question;
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
}
