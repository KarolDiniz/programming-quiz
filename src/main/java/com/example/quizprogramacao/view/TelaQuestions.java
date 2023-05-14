package com.example.quizprogramacao.view;

import javax.swing.*;

public class TelaQuestions extends JFrame {
    private JLabel labelPergunta;
    private JRadioButton[] radioButtons;
    private ButtonGroup buttonGroup;
    private JButton buttonResponder;

    public TelaQuestions() {
        // Pergunta e opções de múltipla escolha
        String pergunta = "Qual é a capital do Brasil?";
        String[] opcoes = {"a) Rio de Janeiro", "b) São Paulo", "c) Brasília", "d) Salvador"};

        // Configurando a janela
        setTitle("Quiz");
        setLayout(null);
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando os componentes
        labelPergunta = new JLabel(pergunta);
        radioButtons = new JRadioButton[opcoes.length];
        buttonGroup = new ButtonGroup();
        buttonResponder = new JButton("Responder");

        // Configurando os componentes
        labelPergunta.setBounds(50, 50, 300, 20);
        int y = 80;
        for (int i = 0; i < opcoes.length; i++) {
            radioButtons[i] = new JRadioButton(opcoes[i]);
            radioButtons[i].setBounds(50, y, 300, 20);
            buttonGroup.add(radioButtons[i]);
            add(radioButtons[i]);
            y += 30;
        }
        buttonResponder.setBounds(50, y, 100, 30);

        // Adicionando os componentes à janela
        add(labelPergunta);
        add(buttonResponder);

        // Adicionando a ação ao botão de responder
        buttonResponder.addActionListener(e -> {
            String resposta = "";
            for (JRadioButton radioButton : radioButtons) {
                if (radioButton.isSelected()) {
                    resposta = radioButton.getText().substring(0, 1);
                    break;
                }
            }

            // Verificando a resposta
            if (resposta.equalsIgnoreCase("c")) {
                JOptionPane.showMessageDialog(this, "Resposta correta!");
            } else {
                JOptionPane.showMessageDialog(this, "Resposta incorreta!");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            TelaQuestions tela = new TelaQuestions();
            tela.setVisible(true);
        });
    }
}
