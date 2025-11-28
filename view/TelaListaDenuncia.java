package view;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import controller.DenunciaController;
import model.Denuncia;
import java.util.List;

public class TelaListaDenuncias extends JFrame {

    public TelaListaDenuncias(DenunciaController controller) {
        setTitle("Lista de Denúncias");
        setSize(600, 400);
        setLocationRelativeTo(null);

        String[] colunas = {"ID", "Título", "Categoria", "Endereço"};
        DefaultTableModel modelo = new DefaultTableModel(colunas, 0);

        JTable tabela = new JTable(modelo);
        JScrollPane scroll = new JScrollPane(tabela);

        List<Denuncia> denuncias = controller.listar();

        for (Denuncia d : denuncias) {
            Object[] linha = {
                d.getId(),
                d.getTitulo(),
                d.getCategoria(),
                d.getEndereco()
            };
            modelo.addRow(linha);
        }

        add(scroll);
    }
}