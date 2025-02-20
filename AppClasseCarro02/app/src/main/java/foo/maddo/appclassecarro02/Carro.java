package foo.maddo.appclassecarro02;

import android.util.Log;

public class Carro {

    private String fabricante;
    private String modelo;
    private String ano;
    private String cor;

    public Carro() {

        Log.i("Carro", "Carro criado");

    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
