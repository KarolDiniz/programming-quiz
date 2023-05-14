package com.example.quizprogramacao.question;

import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
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
            cursor.close();
        }
        return questions;
    }

    public InsertOneResult addQuestion(Document question) {
        // Inserindo o novo documento na coleção
        return collection.insertOne(question);
    }
    public Document seachQuestionLessExecuted(){
        // Executando a consulta para buscar a pergunta menos feita
        Document perguntaMenosFeita = collection.find().sort(new BasicDBObject("quantidade", 1)).limit(1).first();
        // Fechando a conexão com o banco de dados
        mongoClient.close();
        return perguntaMenosFeita;
    }
    public DeleteResult deleteQuestion(String id) {
       /* // Cria um filtro para o ID da pergunta
        Bson filter = Filters.eq("_id", iD);*/
        // Executando a consulta para deletar a pergunta menos feita
        DeleteResult result = collection.deleteOne(new Document("_id", new ObjectId(id)));

        mongoClient.close();
        return result;
    }
    public Question seachById(String id) {
        return null;
    }

}

