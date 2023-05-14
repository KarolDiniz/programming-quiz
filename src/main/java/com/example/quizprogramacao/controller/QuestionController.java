package com.example.quizprogramacao.controller;

import com.example.quizprogramacao.model.Question;
import com.example.quizprogramacao.repository.QuestionRepository;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.springframework.beans.factory.annotation.Autowired;
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

    @DeleteMapping("/delete")
    public DeleteResult dropQuestion(String id) {
        return questionRepository.deleteQuestion(id);
    }

    @GetMapping("/search")
    public List<Question> listQuestionSpecific(String keyword){
        return questionRepository.searchQuestionsByKeyword(keyword);
    }

}


