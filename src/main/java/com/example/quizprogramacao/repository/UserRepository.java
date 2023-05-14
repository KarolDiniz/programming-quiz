package com.example.quizprogramacao.repository;

import com.example.quizprogramacao.connection.MongoDBConnection;
import com.example.quizprogramacao.mapper.DocumentMapper;
import com.example.quizprogramacao.model.User;
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class UserRepository {

    // Conexão com o banco de dados
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    // Selecionando o banco de dados
    MongoDatabase database = mongoClient.getDatabase("quiz");
    // Selecionando a coleção
    MongoCollection<Document> collection = database.getCollection("users");

    public InsertOneResult addUser(Document user) {
        // Inserindo o novo documento na coleção
        return collection.insertOne(user);
    }

    public DeleteResult deleteUser(String id) {
        // Executando a consulta para deletar a pergunta menos feita
        DeleteResult result = collection.deleteOne(new Document("_id", new ObjectId(id)));

        MongoDBConnection.close();
        return result;
    }
}
