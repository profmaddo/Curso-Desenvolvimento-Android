package android.curso.mediaescolarmvc.controller;

import android.content.ContentValues;
import android.content.Context;
import android.curso.mediaescolarmvc.datamodel.MediaEscolarDataModel;
import android.curso.mediaescolarmvc.datasource.DataSource;
import android.curso.mediaescolarmvc.model.MediaEscolar;

/**
 * Created by marcomaddo on 18/01/2018.
 */

public class MediaEscolarController extends DataSource{

    ContentValues dados;

    public MediaEscolarController(Context context) {
        super(context);
    }

    // TODO: Implementar calculo da média
    public void calcularMedia() {

    }

    // TODO: Implementar calculo do resultado final
    public void resultadoFinal() {

    }

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
    

}
