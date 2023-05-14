package com.example.quizprogramacao.connection;

import com.mongodb.client.*;
import org.bson.Document;

public class MongoDBConnection {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void connect() {
        // Conexão com o banco de dados
        mongoClient = MongoClients.create("mongodb://localhost:27017");
        // Selecionando o banco de dados
        database = mongoClient.getDatabase("quiz");
    }

    public static void close() {
        mongoClient.close();
    }

    public static MongoCollection<Document> getCollection(String nameCollection){
        return database.getCollection(nameCollection);
    }
    public static MongoCursor<Document> getCursor(MongoCollection<Document> collection){
        return collection.find().iterator();
    }
}
