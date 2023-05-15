package com.example.quizprogramacao.view;

import com.example.quizprogramacao.model.Question;
import com.example.quizprogramacao.repository.QuestionRepository;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class TelaQuestions extends JanelaPadrao {
    private JLabel labelPergunta;
    private JLabel labelResposta;
    private JRadioButton[] radioButtons;
    private JButton buttonResponder;
    private List<Question> questions;

    public TelaQuestions() {
        super("Quiz de programação", 400, 300);
        // Configurando a janela
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(135,206,250));
        QuestionRepository questionRepository = new QuestionRepository();
        questions = questionRepository.listAllQuestions();

        // Criando os componentes
        final int[] posicaoSelecionada = {-1};
        final int[] contador = {0};

        // Criando os componentes
        labelPergunta = new JLabel(questions.get(contador[0]).getPergunta());
        radioButtons = new JRadioButton[questions.get(contador[0]).getOpcoes().size()];
        for (int j = 0; j < radioButtons.length; j++) {
            int posicaoAtual = j;
            radioButtons[j] = new JRadioButton(questions.get(contador[0]).getOpcoes().get(j));
            radioButtons[j].addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    posicaoSelecionada[0] = posicaoAtual;
                }
            });
        }
        buttonResponder = new JButton("Responder");
        final int[] finalI = {contador[0]};
        buttonResponder.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Comparar a resposta selecionada com a resposta correta
                if (posicaoSelecionada[0] == questions.get(finalI[0]).getResposta()) {
                    JOptionPane.showMessageDialog(null,"Resposta correta!");
                } else {
                    JOptionPane.showMessageDialog(null,"Resposta incorreta!");
                }

                // Avança para a próxima pergunta
                contador[0]++;
                if (contador[0] < questions.size()) {
                    labelPergunta.setText(questions.get(contador[0]).getPergunta());
                    for (int j = 0; j < radioButtons.length; j++) {
                        radioButtons[j].setText(questions.get(contador[0]).getOpcoes().get(j));
                    }
                    posicaoSelecionada[0] = -1;
                    finalI[0] = contador[0];
                } else {
                    JOptionPane.showMessageDialog(null,"Fim do quiz!");
                    // Aqui você pode implementar o que deve ser feito quando acabarem as perguntas
                }
            }
        });

// Configurando os componentes
        labelPergunta.setBounds(50, 50, 300, 20);
        int y = 80;
        for (int i = 0; i < radioButtons.length; i++) {
            radioButtons[i].setBounds(50, y, 300, 20);
            y += 30;
        }
        buttonResponder.setBounds(150, y, 100, 30);
        buttonResponder.setBackground(new Color(70,130,180));

// Adicionando os componentes à janela
        add(labelPergunta);
        for (JRadioButton radioButton : radioButtons) {
            add(radioButton);
        }
        add(buttonResponder);
    }
}