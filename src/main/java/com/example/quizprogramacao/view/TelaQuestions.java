package com.example.quizprogramacao.view;

import javax.swing.*;

public class TelaQuestions extends JanelaPadrao {
    private JLabel labelPergunta;
    private JRadioButton[] radioButtons;
    private JButton buttonResponder;

    public TelaQuestions() {
        super("Quiz de programação", 400, 300);
        // Configurando a janela
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando os componentes
        labelPergunta = new JLabel("Qual é a capital do Brasil?");
        radioButtons = new JRadioButton[4];
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i] = new JRadioButton("Opção " + (i + 1));
        }
        buttonResponder = new JButton("Responder");

        // Configurando os componentes
        labelPergunta.setBounds(50, 50, 300, 20);
        int y = 80;
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setBounds(50, y, 300, 20);
            y += 30;
        }
        buttonResponder.setBounds(150, y, 100, 30);

        // Adicionando os componentes à janela
        add(labelPergunta);
        for (JRadioButton radioButton : radioButtons) {
            add(radioButton);
        }
        add(buttonResponder);
    }
}