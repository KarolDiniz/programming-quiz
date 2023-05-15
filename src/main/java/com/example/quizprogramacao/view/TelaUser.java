package com.example.quizprogramacao.view;
import com.example.quizprogramacao.controller.UserController;
import com.example.quizprogramacao.mapper.ConvertObjectToDocument;
import com.example.quizprogramacao.model.User;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

import javax.swing.*;

import javax.swing.*;
import java.awt.*;

public class TelaUser extends JanelaPadrao {
    private JLabel labelNome;
    private JLabel labelEmail;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JButton buttonCadastrar;

    public TelaUser() {
        // Configurando a janela
        super("Cadastro USER", 400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(135,206,250));
        setResizable(false);

        // Criando os componentes
        labelNome = new JLabel("Nome:");
        labelEmail = new JLabel("Email:");
        labelNome.setForeground(Color.WHITE);
        labelEmail.setForeground(Color.WHITE);

        textFieldNome = new JTextField();
        textFieldEmail = new JTextField();

        buttonCadastrar = new JButton("Cadastrar");
        buttonCadastrar.setBackground(new Color(70,130,180));

        // Configurando os componentes
        labelNome.setBounds(50, 50, 100, 20);
        labelEmail.setBounds(50, 80, 100, 20);

        textFieldNome.setBounds(150, 50, 200, 20);
        textFieldEmail.setBounds(150, 80, 200, 20);

        buttonCadastrar.setBounds(150, 150, 100, 30);

        // Adicionando os componentes à janela
        add(labelNome);
        add(labelEmail);
        add(textFieldNome);
        add(textFieldEmail);
        add(buttonCadastrar);

        // Adicionando a ação ao botão de cadastrar
        buttonCadastrar.addActionListener(e -> {
            String nome = textFieldNome.getText();
            String email = textFieldEmail.getText();

            User user = new User(nome, email);
            UserController userController = new UserController();
            userController.addUser(user);

            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
            this.dispose();
            new TelaMenu();
        });
        setVisible(true);
    }
}
