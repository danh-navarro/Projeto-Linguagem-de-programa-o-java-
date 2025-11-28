package dao;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import model.Denuncia;

public class DenunciaDAO {

    private static final String ARQUIVO = "data/denuncias.txt";

    // ----------------------------------------------------
    // SALVAR NOVA DENÚNCIA
    // ----------------------------------------------------
    public boolean salvar(Denuncia denuncia) {

        // Gerar ID
        int novoId = gerarNovoId();
        denuncia.setIdInterno(novoId); // id gerado internamente

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO, true))) {

            bw.write(denuncia.toString());
            bw.newLine();

            return true;

        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ----------------------------------------------------
    // LISTAR TODAS AS DENÚNCIAS
    // ----------------------------------------------------
    public List<Denuncia> listar() {

        List<Denuncia> lista = new ArrayList<>();

        File f = new File(ARQUIVO);
        if (!f.exists()) return lista;

        try (BufferedReader br = new BufferedReader(new FileReader(ARQUIVO))) {

            String linha;
            while ((linha = br.readLine()) != null) {
                try {
                    Denuncia d = Denuncia.fromString(linha);
                    lista.add(d);
                } catch (Exception ex) {
                    // linha inválida, ignora
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }

        return lista;
    }

    // ----------------------------------------------------
    // BUSCAR POR ID
    // ----------------------------------------------------
    public Denuncia buscarPorId(int id) {
        for (Denuncia d : listar()) {
            if (d.getId() == id) return d;
        }
        return null;
    }

    // ----------------------------------------------------
    // ATUALIZAR DENÚNCIA
    // ----------------------------------------------------
    public boolean atualizar(Denuncia denunciaEditada) {
        List<Denuncia> lista = listar();
        boolean encontrado = false;

        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getId() == denunciaEditada.getId()) {
                lista.set(i, denunciaEditada);
                encontrado = true;
                break;
            }
        }

        if (!encontrado) return false;

        return reescreverArquivo(lista);
    }

    // ----------------------------------------------------
    // REMOVER DENÚNCIA
    // ----------------------------------------------------
    public boolean remover(int id) {
        List<Denuncia> lista = listar();
        boolean removeu = lista.removeIf(d -> d.getId() == id);
        if (!removeu) return false;
        return reescreverArquivo(lista);
    }

    // ----------------------------------------------------
    // REESCREVER ARQUIVO
    // ----------------------------------------------------
    private boolean reescreverArquivo(List<Denuncia> lista) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(ARQUIVO))) {
            for (Denuncia d : lista) {
                bw.write(d.toString());
                bw.newLine();
            }
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }

    // ----------------------------------------------------
    // GERAR NOVO ID
    // ----------------------------------------------------
    private int gerarNovoId() {
        List<Denuncia> lista = listar();
        int maior = 0;
        for (Denuncia d : lista) {
            if (d.getId() > maior) maior = d.getId();
        }
        return maior + 1;
    }
}