package com.example.quizprogramacao.controller;

import com.example.quizprogramacao.model.Question;
import com.example.quizprogramacao.question.QuestionRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import org.bson.Document;

import java.util.List;


@RestController
@RequestMapping("/api/questions")
public class QuestionController {

    @Autowired
    private QuestionRepository questionRepository;

    @GetMapping("/all")
    public List<Question> listAllQuestions() {
        return questionRepository.listAllQuestions();
    }

    @PostMapping("/create")
    public InsertOneResult addQuestion(@RequestBody Document question) {
        return questionRepository.addQuestion(question);
    }

    @DeleteMapping("/dropQuestion/{id}")
    public DeleteResult deleteQuestion(String id) {
        return questionRepository.deleteQuestion(id);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Question> buscarPorId(@PathVariable String id) {
        Question pergunta = questionRepository.seachById(id);
        if (pergunta == null) {
            System.out.println("Não Entrou");
            return ResponseEntity.notFound().build();
        } else {
            System.out.println("Entroua");
            return ResponseEntity.ok(pergunta);
        }
    }

}

