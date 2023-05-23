package com.example.quizprogramacao.repository;
import com.example.quizprogramacao.model.Game;
import com.mongodb.client.*;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

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

    public List<Game> getAllGames() {
        List<Game> games = new ArrayList<>();

        // Buscar todos os documentos na coleção
        FindIterable<Document> documents = collection.find();

        // Iterar sobre os documentos e mapeá-los para objetos Game
        try (MongoCursor<Document> cursor = documents.iterator()) {
            while (cursor.hasNext()) {
                Document document = cursor.next();
                Game game = new Game(
                        document.getString("playerID"),
                        document.getString("playerNome"),
                        document.getInteger("score"),
                        document.getInteger("wrongAnswers")
                );
                games.add(game);
            }
        }

        return games;
    }
}
