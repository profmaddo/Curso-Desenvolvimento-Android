package maddo.foo.poopolimorfirmouniversalsubtipagem;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;


/**
 * Exemplo de Poliforfismo Universal
 * Subtipagem
 */
public class MainActivity extends AppCompatActivity {

    Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnIniciar = findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                transportarAlgo();

            }
        });


    }

    private void transportarAlgo() {

        IniciarTransporte obj = new IniciarTransporte();

        obj.criarUmTransporte(new Transporte());
        obj.criarUmTransporte(new Aviao());
        obj.criarUmTransporte(new Navio());
        obj.criarUmTransporte(new Carro());
        obj.criarUmTransporte(new Trem());


    }


}
