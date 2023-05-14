package com.example.quizprogramacao.view;

import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaUser telaUser = new TelaUser();
            telaUser.setVisible(true);

            TelaQuestions telaQuestions = new TelaQuestions();
            telaQuestions.setVisible(true);
        });
    }
}
