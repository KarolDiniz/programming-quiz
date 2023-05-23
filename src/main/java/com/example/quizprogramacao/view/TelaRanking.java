package com.example.quizprogramacao.view;

import com.example.quizprogramacao.controller.GameController;
import com.example.quizprogramacao.model.Game;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

import java.util.List;


import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.Comparator;
import java.util.List;

public class TelaRanking extends JFrame {
    private JTable table;

    public TelaRanking() {
        super("Tela: Ranking");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setResizable(false);
        setLayout(new BorderLayout());

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nome");
        model.addColumn("Score");

        table = new JTable(model);
        table.setBackground(new Color(135,206,250));
        JScrollPane scrollPane = new JScrollPane(table);

        GameController game = new GameController();
        List<Game> games = game.returnGames();

        // Ordenar os jogos por score em ordem decrescente
        games.sort(Comparator.comparingInt(Game::getScore).reversed());

        for (Game g : games) {
            String[] rowData = {g.getPlayerName(), String.valueOf(g.getScore())};
            model.addRow(rowData);
        }

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
