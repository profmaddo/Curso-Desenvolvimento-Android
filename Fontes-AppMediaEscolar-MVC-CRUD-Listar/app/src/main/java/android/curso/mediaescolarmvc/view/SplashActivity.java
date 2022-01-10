package android.curso.mediaescolarmvc.view;

import android.content.Intent;
import android.curso.mediaescolarmvc.R;
import android.curso.mediaescolarmvc.controller.MediaEscolarController;
import android.curso.mediaescolarmvc.model.MediaEscolar;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;
import android.util.Log;

import java.util.List;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    MediaEscolarController mediaEscolarController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

         mediaEscolarController =
                new MediaEscolarController(getBaseContext());

         // CRUD - Create Retrieve Update Delete
         // Create  Insert
         // Retrieve Select

        MediaEscolar mediaEscolar;

        for (int i = 0; i < 2000 ; i++) {

            mediaEscolar = new MediaEscolar();

            mediaEscolar.setMateria("Materia "+i);
            mediaEscolar.setBimestre("Bimestre "+i);
            mediaEscolar.setSituacao("Situação "+i);
            mediaEscolar.setNotaMateria(9.99);
            mediaEscolar.setNotaProva(9.80);

            mediaEscolarController.salvar(mediaEscolar);

            Log.i("dbSalvar",mediaEscolar.getMateria());

        }

        apresentarTelaSplash();

    }

    private void apresentarTelaSplash() {

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



              List<MediaEscolar> objetos = mediaEscolarController.listar();

                for (MediaEscolar obj: objetos) {

                    Log.i("dbListar", "ID: "+obj.getId()+" - Matéria: "+obj.getMateria()+" - Situação: "+obj.getSituacao());

                }


                Intent telaPrincipal
                        = new Intent(SplashActivity.this,
                        MainActivity.class);

                startActivity(telaPrincipal);

                finish();

            }
        }, SPLASH_TIME_OUT);


    }
}
