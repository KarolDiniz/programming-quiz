package com.example.quizprogramacao.view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TelaMenu extends JanelaPadrao {
    public TelaMenu() {
        super("Tela: MENU", 350, 250);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setResizable(false);
        setLayout(null);

        JLabel label = new JLabel("Programming Quiz");
        label.setBounds(50, 20, 200, 30);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        add(label);

        JButton btnIniciarQuiz = new JButton("Iniciar Quiz");
        btnIniciarQuiz.setBounds(100, 70, 150, 30);
        btnIniciarQuiz.setBackground(new Color(70,130,180));

        JButton btnRankingQuiz = new JButton("Ranking Quiz");
        btnRankingQuiz.setBounds(100, 120, 150, 30);
        btnRankingQuiz.setBackground(new Color(70,130,180));
        btnRankingQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Loading ranking ...");
                dispose();
                new TelaRanking();
            }
        });

        JButton btnCadastrar = new JButton("Cadastrar");
        btnCadastrar.setBounds(100, 170, 150, 30);
        btnCadastrar.setBackground(new Color(70, 130, 180));

        btnCadastrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Loading cadastro-user ...");
                dispose();
                new TelaUser();
            }
        });
                btnIniciarQuiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Lógica para iniciar o quiz
                JOptionPane.showMessageDialog(null, "Iniciando o quiz...");
                dispose();
                new TelaQuestions();
            }
        });

        add(btnIniciarQuiz);
        add(btnRankingQuiz);
        add(btnCadastrar);
        setVisible(true);
    }
}
