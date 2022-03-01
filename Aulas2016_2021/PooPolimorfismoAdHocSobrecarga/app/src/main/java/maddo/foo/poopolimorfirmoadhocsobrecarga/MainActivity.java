package maddo.foo.poopolimorfirmoadhocsobrecarga;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnContaCorrente;
    Button btnContaSalario;
    Button btnContaPoupanca;

    ContaBancaria contaBancaria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        btnContaCorrente = findViewById(R.id.btnContaCorrente);
        btnContaSalario = findViewById(R.id.btnContaSalario);
        btnContaPoupanca = findViewById(R.id.btnContaPoupanca);


        btnContaCorrente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contaBancaria = new ContaBancaria();
            }
        });

        btnContaSalario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contaBancaria = new ContaBancaria(1000.00);
            }
        });

        btnContaPoupanca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                contaBancaria = new ContaBancaria(1000.00, 500);
            }
        });
    }
}
