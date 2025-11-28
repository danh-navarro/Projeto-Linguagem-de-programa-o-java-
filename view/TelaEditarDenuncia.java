package view;

import javax.swing.*;
import controller.DenunciaController;
import model.Denuncia;

public class TelaEditarDenuncia extends JFrame {

    public TelaEditarDenuncia(DenunciaController controller, Denuncia denuncia) {

        setTitle("Editar Denúncia");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblTitulo = new JLabel("Título:");
        lblTitulo.setBounds(20, 20, 100, 25);

        JTextField txtTitulo = new JTextField(denuncia.getTitulo());
        txtTitulo.setBounds(120, 20, 200, 25);

        JLabel lblDescricao = new JLabel("Descrição:");
        lblDescricao.setBounds(20, 60, 100, 25);

        JTextArea txtDescricao = new JTextArea(denuncia.getDescricao());
        JScrollPane scroll = new JScrollPane(txtDescricao);
        scroll.setBounds(120, 60, 200, 80);

        JLabel lblCategoria = new JLabel("Categoria:");
        lblCategoria.setBounds(20, 160, 100, 25);

        JTextField txtCategoria = new JTextField(denuncia.getCategoria());
        txtCategoria.setBounds(120, 160, 200, 25);

        JLabel lblEndereco = new JLabel("Endereço:");
        lblEndereco.setBounds(20, 200, 100, 25);

        JTextField txtEndereco = new JTextField(denuncia.getEndereco());
        txtEndereco.setBounds(120, 200, 200, 25);

        JButton btnSalvar = new JButton("Salvar Alterações");
        btnSalvar.setBounds(120, 250, 150, 30);

        btnSalvar.addActionListener(e -> {
            String msg = controller.editarDenuncia(
                denuncia.getId(),
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