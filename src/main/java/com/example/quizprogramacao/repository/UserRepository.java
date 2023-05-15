package com.example.quizprogramacao.repository;

import com.example.quizprogramacao.connection.MongoDBConnection;
import com.example.quizprogramacao.mapper.DocumentMapper;
import com.example.quizprogramacao.model.User;
import com.example.quizprogramacao.view.TelaMenu;
import com.mongodb.BasicDBObject;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.result.DeleteResult;
import com.mongodb.client.result.InsertOneResult;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;
import org.springframework.stereotype.Repository;

import javax.swing.*;
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

    public InsertOneResult addUser(User user) {
        // Criar o documento
        Document userDocument = new Document();
        userDocument.append("name", user.getName());
        userDocument.append("email", user.getEmail());

        // Inserindo o novo documento na coleção
        return collection.insertOne(userDocument);
    }
    public DeleteResult deleteUser(String id) {
        // Executando a consulta para deletar a pergunta menos feita
        return collection.deleteOne(new Document("_id", new ObjectId(id)));
    }

    public User returnUserByEmail(String email){
        Bson filter = Filters.eq("email", email);
        Document userDoc = collection.find(filter).first();
        if (userDoc != null) {
            User user = new User(
                    userDoc.getString("name"),
                    userDoc.getString("email")
            );
            // Fazer algo com o usuário encontrado
            return user;
        } else{
            JOptionPane.showMessageDialog(null,"User não encontrado!");
            new TelaMenu();
            return null;
        }
    }
}
