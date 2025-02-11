package foo.maddo.poopolimorfirmoadhocsobrecarga;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnContaCorrente;
    Button btnContaSalario;
    Button btnContaPoupanca;

    ContaBancaria contaBancaria;

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