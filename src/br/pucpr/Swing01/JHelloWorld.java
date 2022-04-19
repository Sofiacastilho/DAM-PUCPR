package br.pucpr.Swing01;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class JHelloWorld extends JFrame {
    public JHelloWorld() {
    super ("primeira janela.");
        setSize(400,400);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        setLayout(null);// <---não recomendado
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                var selecionado = JOptionPane.showConfirmDialog(JHelloWorld.this,
                        "Encerrar programa?",
                        "Confirmação.)",
                        JOptionPane.YES_NO_OPTION);
                if (selecionado == JOptionPane.YES_OPTION) {
                    dispose();
                }
            }
        });

        var lblNome = new JLabel("Nome: ");
        lblNome.setBounds(10,10,100,10);
        add(lblNome);

        var txtNome = new JTextField();
        txtNome.setBounds(60,10,300,20);
        add(txtNome);

        var btnDizerOla = new JButton();
        btnDizerOla.setBounds(10,50,150,22);
        btnDizerOla.setText("Dizer hello!");
        btnDizerOla.addActionListener((e) -> {
            JOptionPane.showMessageDialog(this, "Olá, " + txtNome.getText());

        });

        add(btnDizerOla);






    }
}
