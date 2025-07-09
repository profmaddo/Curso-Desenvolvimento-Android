package foo.maddo.appaula03bancodedadossqlite.model;

public class Endereco {
    private long id;
    private String endereco;
    private String cidade;
    private String estado;

    public Endereco() {
        // Construtor vazio para SQLite
    }

    public Endereco(String endereco, String cidade, String estado) {
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public Endereco(long id, String endereco, String cidade, String estado) {
        this.id = id;
        this.endereco = endereco;
        this.cidade = cidade;
        this.estado = estado;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "id=" + id +
                ", endereco='" + endereco + '\'' +
                ", cidade='" + cidade + '\'' +
                ", estado='" + estado + '\'' +
                '}';
    }
}



