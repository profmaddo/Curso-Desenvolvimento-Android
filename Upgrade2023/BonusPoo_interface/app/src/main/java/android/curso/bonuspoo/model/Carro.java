package android.curso.bonuspoo.model;

import android.curso.bonuspoo.controller.VeiculoInterface;
import android.util.Log;

/*
 * Sub Classe Carro que herda
 * todas as característica da
 * Classe Fabricante
 */
public class Carro extends Fabricante implements VeiculoInterface {

    private String modelo;
    private String ano;
    private String cor;

    public Carro(){
        Log.i("BunosPoo",
                "Novo Objeto Carro criado");

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

    @Override
    public void opcionalGPS() {

        // regra de negócio para GPS

    }

    @Override
    public void opcionalArCondicionado() {

    }
}