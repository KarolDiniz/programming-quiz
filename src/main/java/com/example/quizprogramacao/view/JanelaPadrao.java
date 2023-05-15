package com.example.quizprogramacao.view;

import javax.swing.*;
import java.awt.*;

public class JanelaPadrao extends JFrame {
    public JanelaPadrao(String titulo, int largura, int altura) {
        setTitle(titulo);
        setSize(largura, altura);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(135,206,250));
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }
}
