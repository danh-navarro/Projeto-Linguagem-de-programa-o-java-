package controller;

import java.util.List;
import dao.DenunciaDAO;
import model.Denuncia;

public class DenunciaController {

    private DenunciaDAO dao = new DenunciaDAO();

    // ---------------------------------------------
    // CRIAR NOVA DENÚNCIA
    // ---------------------------------------------
    public String criarDenuncia(String titulo, String descricao, String categoria,
                                String endereco, String data) {

        if (titulo == null || titulo.trim().isEmpty()) return "Erro: título vazio";
        if (descricao == null || descricao.trim().length() < 10) return "Erro: descrição muito curta";
        if (categoria == null || categoria.trim().isEmpty()) return "Erro: categoria obrigatória";
        if (endereco == null || endereco.trim().isEmpty()) return "Erro: endereço obrigatório";
        if (data == null || data.trim().isEmpty()) return "Erro: data obrigatória";

        Denuncia d = new Denuncia(0, titulo, descricao, categoria, endereco, data, "ABERTA");

        boolean sucesso = dao.salvar(d);

        return sucesso ? "Denúncia registrada com sucesso!" : "Erro ao registrar denúncia!";
    }

    // ---------------------------------------------
    // EDITAR DENÚNCIA
    // ---------------------------------------------
    public String editarDenuncia(int id, String titulo, String descricao,
                                 String categoria, String endereco, String data) {

        Denuncia d = dao.buscarPorId(id);
        if (d == null) return "Erro: denúncia não encontrada";

        // validações
        if (titulo == null || titulo.trim().isEmpty()) return "Erro: título vazio";
        if (descricao == null || descricao.trim().length() < 10) return "Erro: descrição muito curta";
        if (categoria == null || categoria.trim().isEmpty()) return "Erro: categoria obrigatória";
        if (endereco == null || endereco.trim().isEmpty()) return "Erro: endereço obrigatório";
        if (data == null || data.trim().isEmpty()) return "Erro: data obrigatória";

        d.setTitulo(titulo);
        d.setDescricao(descricao);
        d.setCategoria(categoria);
        d.setEndereco(endereco);
        d.setData(data);

        boolean ok = dao.atualizar(d);

        return ok ? "Denúncia atualizada com sucesso!" : "Erro ao atualizar denúncia!";
    }

    // ---------------------------------------------
    // REMOVER DENÚNCIA
    // ---------------------------------------------
    public String removerDenuncia(int id) {
        Denuncia d = dao.buscarPorId(id);
        if (d == null) return "Erro: denúncia não encontrada";
        boolean ok = dao.remover(id);
        return ok ? "Denúncia removida com sucesso!" : "Erro ao remover denúncia!";
    }

    // ---------------------------------------------
    // LISTAR TODAS
    // ---------------------------------------------
    public List<Denuncia> listar() {
        return dao.listar();
    }

    // ---------------------------------------------
    // BUSCAR POR ID
    // ---------------------------------------------
    public Denuncia buscarPorId(int id) {
        return dao.buscarPorId(id);
    }
}