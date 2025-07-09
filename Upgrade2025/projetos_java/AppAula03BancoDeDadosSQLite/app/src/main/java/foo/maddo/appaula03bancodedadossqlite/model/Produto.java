package foo.maddo.appaula03bancodedadossqlite.model;

public class Produto {
    private long id;
    private String descricao;
    private String unidade;
    private double quantidade;
    private double valor;
    private boolean estoque;
    private long fornecedorId; // Referência ao ID do fornecedor

    public Produto() {
        // Construtor vazio para SQLite
    }

    public Produto(String descricao, String unidade, double quantidade, double valor, boolean estoque, long fornecedorId) {
        this.descricao = descricao;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.valor = valor;
        this.estoque = estoque;
        this.fornecedorId = fornecedorId;
    }

    public Produto(long id, String descricao, String unidade, double quantidade, double valor, boolean estoque, long fornecedorId) {
        this.id = id;
        this.descricao = descricao;
        this.unidade = unidade;
        this.quantidade = quantidade;
        this.valor = valor;
        this.estoque = estoque;
        this.fornecedorId = fornecedorId;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public double getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(double quantidade) {
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isEstoque() {
        return estoque;
    }

    public void setEstoque(boolean estoque) {
        this.estoque = estoque;
    }

    public long getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(long fornecedorId) {
        this.fornecedorId = fornecedorId;
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", descricao='" + descricao + '\'' +
                ", unidade='" + unidade + '\'' +
                ", quantidade=" + quantidade +
                ", valor=" + valor +
                ", estoque=" + estoque +
                ", fornecedorId=" + fornecedorId +
                '}';
    }
}