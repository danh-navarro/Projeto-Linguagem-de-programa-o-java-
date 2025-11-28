package view;

import javax.swing.*;
import controller.DenunciaController;

public class TelaCadastroDenuncia extends JFrame {

    public TelaCadastroDenuncia(DenunciaController controller) {
        setTitle("Registrar Denúncia");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 20, 100, 25);

        JTextField txtTitulo = new JTextField();
        txtTitulo.setBounds(120, 20, 200, 25);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(20, 60, 100, 25);

        JTextArea txtDescricao = new JTextArea();
        JScrollPane scroll = new JScrollPane(txtDescricao);
        scroll.setBounds(120, 60, 200, 80);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(20, 160, 100, 25);

        JTextField txtCategoria = new JTextField();
        txtCategoria.setBounds(120, 160, 200, 25);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20, 200, 100, 25);

        JTextField txtEndereco = new JTextField();
        txtEndereco.setBounds(120, 200, 200, 25);

        JButton btnSalvar = new JButton("Salvar");
        btnSalvar.setBounds(140, 250, 100, 30);

        btnSalvar.addActionListener(e -> {
            String msg = controller.criarDenuncia(
                txtTitulo.getText(),
                txtDescricao.getText(),
                txtCategoria.getText(),
                txtEndereco.getText()
            );
            JOptionPane.showMessageDialog(this, msg);
        });

        add(lblTitulo);
        add(txtTitulo);
        add(lblDescricao);
        add(scroll);
        add(lblCategoria);
        add(txtCategoria);
        add(lblEndereco);
        add(txtEndereco);
        add(btnSalvar);
    }
}