package model;

public class Denuncia {
    private int id;
    private String titulo;
    private String descricao;
    private String categoria;
    private String endereco;
    private String data;
    private String status; // ABERTA, EM ANDAMENTO, CONCLUIDA

    // Construtor completo
    public Denuncia(int id, String titulo, String descricao, String categoria,
                    String endereco, String data, String status) {
        this.id = id;
        this.titulo = titulo;
        this.descricao = descricao;
        this.categoria = categoria;
        this.endereco = endereco;
        this.data = data;
        this.status = status;
    }

    // -----------------------------------
    // Getters
    // -----------------------------------
    public int getId() { return id; }
    public String getTitulo() { return titulo; }
    public String getDescricao() { return descricao; }
    public String getCategoria() { return categoria; }
    public String getEndereco() { return endereco; }
    public String getData() { return data; }
    public String getStatus() { return status; }

    // -----------------------------------
    // Setters
    // -----------------------------------
    public void setTitulo(String titulo) { this.titulo = titulo; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public void setData(String data) { this.data = data; }
    public void setStatus(String status) { this.status = status; }

    // Setter interno apenas para o DAO
    public void setIdInterno(int id) { this.id = id; }

    // -----------------------------------
    // Para salvar em TXT
    // -----------------------------------
    @Override
    public String toString() {
        return id + ";" + titulo + ";" + descricao + ";" + categoria + ";" +
               endereco + ";" + data + ";" + status;
    }

    // Ler do TXT
    public static Denuncia fromString(String linha) {
        String[] p = linha.split(";");
        if (p.length != 7) throw new IllegalArgumentException("Linha inválida");
        int id = Integer.parseInt(p[0]);
        return new Denuncia(id, p[1], p[2], p[3], p[4], p[5], p[6]);
    }
}