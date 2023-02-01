package android.curso.mediaescolarmvc.view;

import android.content.Intent;
import android.curso.mediaescolarmvc.R;
import android.curso.mediaescolarmvc.controller.MediaEscolarController;
import android.curso.mediaescolarmvc.model.MediaEscolar;
import android.os.Bundle;
import android.os.Handler;
import androidx.appcompat.app.AppCompatActivity;

public class SplashActivity extends AppCompatActivity {

    private static final int SPLASH_TIME_OUT = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        apresentarTelaSplash();

    }


    private void apresentarTelaSplash(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                MediaEscolar obj = new MediaEscolar();

                obj.setMateria("Matemática");
                obj.setBimestre("1º Bimestre");
                obj.setSituacao("Aprovado");
                obj.setNotaProva(10);
                obj.setNotaMateria(10);
                obj.setMediaFinal(10);
                obj.setSituacao("Aprovado");

                MediaEscolarController mediaEscolarController =
                        new MediaEscolarController(getBaseContext());

                mediaEscolarController.salvar(obj);

                Intent telaPrincipal
                        = new Intent(SplashActivity.this,
                        MainActivity.class);

                startActivity(telaPrincipal);

                finish();

            }
        },SPLASH_TIME_OUT);


    }
}
