package foo.maddo.poopolimorfismouniversalsubtipagem;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnIniciar;

    String TAG = "@marcomaddo";
    String TAG_E = "@marcomaddoerro";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Log.d(TAG,"Teste de LOG para DEBUG....");


        btnIniciar = findViewById(R.id.btnIniciar);
        btnIniciar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e(TAG,"Teste de LOG para INFO Click...");

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

        Log.w(TAG,"Teste de LOG para Warning no Método");

    }
}