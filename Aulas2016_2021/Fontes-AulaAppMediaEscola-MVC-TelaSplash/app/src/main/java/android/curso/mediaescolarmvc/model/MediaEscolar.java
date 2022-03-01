package android.curso.mediaescolarmvc.model;

/**
 * Created by marcomaddo on 04/11/2017.
 */


// Pojo

public class MediaEscolar {

    private String materia;
    private String bimestre;
    private String situacao;
    private double notaProva;
    private double notaMateria;
    private double mediaFinal;

    public MediaEscolar(){

    }


    public String getMateria() {
        return materia;
    }

    public void setMateria(String materia) {
        this.materia = materia;
    }

    public String getBimestre() {
        return bimestre;
    }

    public void setBimestre(String bimestre) {
        this.bimestre = bimestre;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    public double getNotaProva() {
        return notaProva;
    }

    public void setNotaProva(double notaProva) {
        this.notaProva = notaProva;
    }

    public double getNotaMateria() {
        return notaMateria;
    }

    public void setNotaMateria(double notaMateria) {
        this.notaMateria = notaMateria;
    }

    public double getMediaFinal() {
        return mediaFinal;
    }

    public void setMediaFinal(double mediaFinal) {
        this.mediaFinal = mediaFinal;
    }
}
