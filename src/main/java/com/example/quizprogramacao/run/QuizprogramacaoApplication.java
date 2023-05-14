package com.example.quizprogramacao.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan("com.example")
@EnableMongoRepositories(basePackages = "com.example.quizprogramacao.repository")
public class QuizprogramacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(QuizprogramacaoApplication.class, args);
	}

}
