package com.example.quizprogramacao.view;
import javax.swing.*;

public class TelaUser extends JanelaPadrao {
    private JLabel labelNome;
    private JLabel labelEmail;
    private JLabel labelSenha;
    private JTextField textFieldNome;
    private JTextField textFieldEmail;
    private JPasswordField passwordFieldSenha;
    private JButton buttonCadastrar;

    public TelaUser() {
        // Configurando a janela
        super("Cadastro USER", 400, 300);
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Criando os componentes
        labelNome = new JLabel("Nome:");
        labelEmail = new JLabel("Email:");
        labelSenha = new JLabel("Senha:");
        textFieldNome = new JTextField();
        textFieldEmail = new JTextField();
        passwordFieldSenha = new JPasswordField();
        buttonCadastrar = new JButton("Cadastrar");

        // Configurando os componentes
        labelNome.setBounds(50, 50, 100, 20);
        labelEmail.setBounds(50, 80, 100, 20);
        labelSenha.setBounds(50, 110, 100, 20);
        textFieldNome.setBounds(150, 50, 200, 20);
        textFieldEmail.setBounds(150, 80, 200, 20);
        passwordFieldSenha.setBounds(150, 110, 200, 20);
        buttonCadastrar.setBounds(150, 150, 100, 30);

        // Adicionando os componentes à janela
        add(labelNome);
        add(labelEmail);
        add(labelSenha);
        add(textFieldNome);
        add(textFieldEmail);
        add(passwordFieldSenha);
        add(buttonCadastrar);

        // Adicionando a ação ao botão de cadastrar
        buttonCadastrar.addActionListener(e -> {
            String nome = textFieldNome.getText();
            String email = textFieldEmail.getText();
            String senha = new String(passwordFieldSenha.getPassword());

            // Realizando o cadastro (simulando aqui)
            // Você precisará substituir esta parte pelo seu código de cadastro real
            System.out.println("Cadastro realizado:");
            System.out.println("Nome: " + nome);
            System.out.println("Email: " + email);
            System.out.println("Senha: " + senha);

            JOptionPane.showMessageDialog(this, "Cadastro realizado com sucesso!");
        });
    }}