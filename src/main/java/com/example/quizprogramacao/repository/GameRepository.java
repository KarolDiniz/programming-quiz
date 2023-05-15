package com.example.quizprogramacao.repository;
import com.example.quizprogramacao.model.Game;
import com.mongodb.client.*;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.springframework.stereotype.Repository;

@Repository
public class GameRepository {

    // Conexão com o banco de dados
    MongoClient mongoClient = MongoClients.create("mongodb://localhost:27017");
    // Selecionando o banco de dados
    MongoDatabase database = mongoClient.getDatabase("quiz");
    // Selecionando a coleção
    MongoCollection<Document> collection = database.getCollection("games");

    public  InsertOneResult addGame(Game game) {
        // Criar o documento
        Document userDocument = new Document();
        userDocument.append("playerID", game.getPlayerName());
        userDocument.append("playerNome", game.getPlayerEmail());
        userDocument.append("score", game.getScore());
        userDocument.append("wrongAnswers",game.getWrongAnswers());

        // Inserindo o novo documento na coleção
        return collection.insertOne(userDocument);
    }
}