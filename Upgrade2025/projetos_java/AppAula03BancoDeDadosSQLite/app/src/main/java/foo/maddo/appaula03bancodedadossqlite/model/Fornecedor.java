package foo.maddo.appaula03bancodedadossqlite.model;

import java.util.List;

public class Fornecedor {
    private long id;
    private String nome;
    private String contato;
    private long enderecoId; // Referência ao ID do endereço
    private List<Produto> produtos;

    public Fornecedor() {
        // Construtor vazio para SQLite
    }

    public Fornecedor(String nome, String contato, long enderecoId) {
        this.nome = nome;
        this.contato = contato;
        this.enderecoId = enderecoId;
    }

    public Fornecedor(long id, String nome, String contato, long enderecoId) {
        this.id = id;
        this.nome = nome;
        this.contato = contato;
        this.enderecoId = enderecoId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getContato() {
        return contato;
    }

    public void setContato(String contato) {
        this.contato = contato;
    }

    public long getEnderecoId() {
        return enderecoId;
    }

    public void setEnderecoId(long enderecoId) {
        this.enderecoId = enderecoId;
    }

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    @Override
    public String toString() {
        return "Fornecedor{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", contato='" + contato + '\'' +
                ", enderecoId=" + enderecoId +
                ", produtos=" + produtos +
                '}';
    }
}
