package com.example.quizprogramacao.repository;

import com.example.quizprogramacao.connection.MongoDBConnection;
import com.example.quizprogramacao.mapper.DocumentMapper;
import com.example.quizprogramacao.model.Question;
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class QuestionRepository{
    // Conexão com o banco de dados
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    // Selecionando o banco de dados
    MongoDatabase database = mongoClient.getDatabase("quiz");
    // Selecionando a coleção
    MongoCollection<Document> collection = database.getCollection("questions");
    // Pegar todos os documentos da coleção
    MongoCursor<Document> cursor = collection.find().iterator();

    // Manipular os dados do mongoDB

    public List<Question> listAllQuestions() {
        List<Question> questions = new ArrayList<>();
        try {
            while (cursor.hasNext()) {
                questions.add(DocumentMapper.map(cursor.next()));
            }
        } finally {
            //cursor.close();
        }
        return questions;
    }

    public InsertOneResult addQuestion(Document question) {
        // Inserindo o novo documento na coleção
        return collection.insertOne(question);
    }
    public Document seachQuestionLessExecuted(){
        // Executando a consulta para buscar a pergunta menos feita
        Document questionLessExecuted = collection.find().sort(new BasicDBObject("quantidade", 1)).limit(1).first();
        // Fechando a conexão com o banco de dados
        return questionLessExecuted;
    }
    public DeleteResult deleteQuestion(String id) {
        MongoDBConnection.connect();
        // Executando a consulta para deletar a pergunta menos feita
        DeleteResult result = collection.deleteOne(new Document("_id", new ObjectId(id)));

        MongoDBConnection.close();
        return result;
    }
    @Autowired
    private MongoTemplate mongoTemplate;

    public List<Question> searchQuestionsByKeyword(String keyword) {
        MongoDBConnection.connect();
        // Crie um objeto Query com a palavra-chave
        Query query = Query.query(
                Criteria.where("pergunta").regex(keyword, "i")
        );
        // Execute a operação find com a consulta
        List<Question> questions = mongoTemplate.find(
                query,
                Question.class
        );
        return questions;
    }
}
