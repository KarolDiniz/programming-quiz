package com.example.quizprogramacao.view;

import com.example.quizprogramacao.model.Question;
import com.example.quizprogramacao.repository.QuestionRepository;

import javax.swing.*;
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
        QuestionRepository questionRepository = new QuestionRepository();
        questions = questionRepository.listAllQuestions();

        // Criando os componentes
        for(int i = 0; i < questions.size();i++){
            labelPergunta = new JLabel(questions.get(i).getPergunta());
            radioButtons = new JRadioButton[questions.get(i).getOpcoes().size()];
            for (int j = 0; j < radioButtons.length; j++) {
                radioButtons[j] = new JRadioButton(questions.get(i).getOpcoes().get(j));
            }
            buttonResponder = new JButton("Responder");
            int finalI = i;
            buttonResponder.addActionListener(new ActionListener(){
                @Override
                public void actionPerformed(ActionEvent e) {
                    // Verificar a resposta selecionada pelo usuário
                    int respostaSelecionada = 0;

                    for (JRadioButton radioButton : radioButtons) {
                        if (radioButton.isSelected()) {
                            respostaSelecionada = 1;
                            break;
                        }
                    }
                    // Comparar a resposta selecionada com a resposta correta
                    if (respostaSelecionada == questions.get(finalI).getResposta()) {
                        JOptionPane.showMessageDialog(null,"Resposta correta!");
                    } else {
                        JOptionPane.showMessageDialog(null,"Resposta incorreta!");
                    }
                }
            });
        }
        hg
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
        setVisible(true);
    }
}