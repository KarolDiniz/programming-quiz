package com.example.quizprogramacao.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu {
    public TelaMenu() {
        JFrame frame = new JFrame("Menu");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 150);

        JPanel panel = new JPanel();
        panel.setLayout(new FlowLayout());

        JButton btnIniciarQuiz = new JButton("Iniciar Quiz");
        JButton btnRankingQuiz = new JButton("Ranking Quiz");

        btnIniciarQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para iniciar o quiz
                JOptionPane.showMessageDialog(null, "Iniciando o quiz...");
            }
        });

        btnRankingQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para exibir o ranking do quiz
                JOptionPane.showMessageDialog(null, "Exibindo o ranking do quiz...");
            }
        });

        panel.add(btnIniciarQuiz);
        panel.add(btnRankingQuiz);
        frame.add(panel);
        frame.setVisible(true);
    }
}