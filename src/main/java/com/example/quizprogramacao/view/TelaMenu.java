package com.example.quizprogramacao.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu {
    public TelaMenu() {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 250);
        frame.setLayout(null);

        JLabel label = new JLabel("Programming Quiz");
        label.setBounds(50, 20, 200, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        frame.add(label);

        JButton btnIniciarQuiz = new JButton("Iniciar Quiz");
        btnIniciarQuiz.setBounds(100, 70, 150, 30);

        JButton btnRankingQuiz = new JButton("Ranking Quiz");
        btnRankingQuiz.setBounds(100, 120, 150, 30);

        btnIniciarQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para iniciar o quiz
                JOptionPane.showMessageDialog(null, "Iniciando o quiz...");
                new TelaQuestions();
            }
        });

        btnRankingQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para exibir o ranking do quiz
                JOptionPane.showMessageDialog(null, "Exibindo o ranking do quiz...");
                //new TelaRanking();
            }
        });

        frame.add(btnIniciarQuiz);
        frame.add(btnRankingQuiz);
        frame.setVisible(true);
    }
}
