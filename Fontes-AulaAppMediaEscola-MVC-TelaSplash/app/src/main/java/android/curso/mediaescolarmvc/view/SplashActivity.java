package android.curso.mediaescolarmvc.view;

import android.content.Intent;
import android.curso.mediaescolarmvc.R;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 *
 * Tela Splash é uma tela de apresentação inicial do
 * aplicativo, pode ser utilizada para executar atualizações
 * enquanto carrega o app
 */

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

                Intent telaPrincipal
                        = new Intent(SplashActivity.this,
                        MainActivity.class);
                startActivity(telaPrincipal);

            }
        },SPLASH_TIME_OUT);


    }
}
