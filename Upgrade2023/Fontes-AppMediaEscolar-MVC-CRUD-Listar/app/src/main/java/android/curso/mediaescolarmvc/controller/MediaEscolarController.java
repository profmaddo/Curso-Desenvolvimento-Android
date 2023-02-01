package android.curso.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;
import android.curso.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import android.curso.mediaescolarmvc.datasource.DataSource;
import android.curso.mediaescolarmvc.model.MediaEscolar;

import java.util.List;

/**
 * Created by marcomaddo on 18/01/2018.
 */

public class MediaEscolarController extends DataSource{

    ContentValues dados;

    public MediaEscolarController(Context context) {
        super(context);
    }

    public void calcularMedia() {

    }

    public void resultadoFinal() {

    }

    /**
     * Método que recebe um objeto MediaEscolar e prepara para enviar
     * para o DataSource e salvar no banco de dados.
     *
     * @param obj é um Objeto MediaEscolar
     * @return verdadeiro se salvou com sucesso, falso em caso de erro.
     * @since versão 1.0-2018
     * @see android.curso.mediaescolarmvc.datasource
     */
    public boolean salvar(MediaEscolar obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = insert(MediaEscolarDataModel.getTABELA(), dados);

        return sucesso;
    }

    public boolean deletar(MediaEscolar obj){

        boolean sucesso = true;

        sucesso = deletar(MediaEscolarDataModel.getTABELA(), obj.getId());

        return sucesso;
    }

    public boolean alterar(MediaEscolar obj){

        boolean sucesso = true;

        dados = new ContentValues();

        dados.put(MediaEscolarDataModel.getId(), obj.getId());
        dados.put(MediaEscolarDataModel.getMateria(), obj.getMateria());
        dados.put(MediaEscolarDataModel.getBimestre(), obj.getBimestre());
        dados.put(MediaEscolarDataModel.getSituacao(), obj.getSituacao());
        dados.put(MediaEscolarDataModel.getNotaProva(), obj.getNotaProva());
        dados.put(MediaEscolarDataModel.getNotaMateria(), obj.getNotaMateria());
        dados.put(MediaEscolarDataModel.getMediaFinal(), obj.getMediaFinal());

        sucesso = alterar(MediaEscolarDataModel.getTABELA(), dados);

        return sucesso;
    }

    public List<MediaEscolar> listar(){
        return getAllMediaEscolar();
    }


}
