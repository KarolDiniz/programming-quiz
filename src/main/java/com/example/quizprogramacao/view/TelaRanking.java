package com.example.quizprogramacao.view;

import com.example.quizprogramacao.model.Game;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.util.ArrayList;

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
        JScrollPane scrollPane = new JScrollPane(table);

        Game game = new Game();
        List<Game> games = game.returnGames();
        for (Game g : games) {
            String[] rowData = {g.getPlayerName(), String.valueOf(g.getScore())};
            model.addRow(rowData);
        }

        add(scrollPane, BorderLayout.CENTER);
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public static void main(String[] args) {
        new TelaRanking();
    }
}
