package android.curso.bonuspoo.model;

import android.util.Log;

/**
 * Created by marcomaddo on 26/10/2017.
 */

public class Carro {

    private String fabricante;
    private String modelo;
    private String ano;
    private String cor;

    public Carro(){
        Log.i("BunosPoo",
                "Novo Objeto Carro criado");
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante)
    {
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