package view;

import javax.swing.*;
import java.awt.*;
import controller.DenunciaController;

public class MenuPrincipal extends JFrame {

    private DenunciaController controller = new DenunciaController();

    public MenuPrincipal() {
        setTitle("Sistema de Denúncias - Prefeitura");
        setSize(400, 250);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnCadastro = new JButton("Registrar Nova Denúncia");
        JButton btnLista = new JButton("Listar Denúncias");
        JButton btnSair = new JButton("Sair");

        // Ações
        btnCadastro.addActionListener(e -> {
            new TelaCadastroDenuncia(controller).setVisible(true);
        });

        btnLista.addActionListener(e -> {
            new TelaListaDenuncias(controller).setVisible(true);
        });

        btnSair.addActionListener(e -> System.exit(0));

        add(btnCadastro);
        add(btnLista);
        add(btnSair);
    }

    public static void main(String[] args) {
        new MenuPrincipal().setVisible(true);
    }
}