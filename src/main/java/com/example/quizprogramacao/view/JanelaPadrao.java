package com.example.quizprogramacao.view;

import javax.swing.*;

public class JanelaPadrao extends JFrame {
    public JanelaPadrao(String titulo, int largura, int altura) {
        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }
}
