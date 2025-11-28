package view;

import javax.swing.*;
import controller.DenunciaController;
import model.Denuncia;

public class TelaRemoverDenuncia extends JFrame {

    public TelaRemoverDenuncia(DenunciaController controller, Denuncia denuncia) {

        setTitle("Remover Denúncia");
        setSize(350, 200);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblMsg = new JLabel("Deseja realmente remover a denúncia?");
        lblMsg.setBounds(30, 20, 300, 25);

        JLabel lblTitulo = new JLabel("Título: " + denuncia.getTitulo());
        lblTitulo.setBounds(30, 50, 300, 25);

        JButton btnSim = new JButton("Sim");
        btnSim.setBounds(60, 100, 80, 30);

        JButton btnNao = new JButton("Não");
        btnNao.setBounds(180, 100, 80, 30);

        btnSim.addActionListener(e -> {
            String msg = controller.removerDenuncia(denuncia.getId());
            JOptionPane.showMessageDialog(this, msg);
            dispose();
        });

        btnNao.addActionListener(e -> dispose());

        add(lblMsg);
        add(lblTitulo);
        add(btnSim);
        add(btnNao);
    }
}