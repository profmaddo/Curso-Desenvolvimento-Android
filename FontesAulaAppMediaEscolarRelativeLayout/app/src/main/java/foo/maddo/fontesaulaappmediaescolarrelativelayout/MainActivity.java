package foo.maddo.fontesaulaappmediaescolarrelativelayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnCalcular;
    EditText editMateria;
    EditText editNotaProva;
    EditText editNotaTrabalho;
    TextView txtResultado;
    TextView txtSituacaoFinal;

    double notaProva;
    double notaTrabalho;
    double media;

    boolean dadosValidados = true;

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

        editMateria = findViewById(R.id.editMateria);
        editNotaProva = findViewById(R.id.editNotaProva);
        editNotaTrabalho = findViewById(R.id.editNotaTrabalho);
        btnCalcular = findViewById(R.id.btnCalcular);
        txtResultado = findViewById(R.id.txtResultado);
        txtSituacaoFinal = findViewById(R.id.txtSituacaoFinal);


        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try {

                    if (editNotaProva.getText().toString().length() > 0) {
                        notaProva = Double.parseDouble(editNotaProva.getText().toString());
                    } else {
                        editNotaProva.setError("*");
                        editNotaProva.requestFocus();
                        dadosValidados =false;
                    }


                    if (editNotaTrabalho.getText().toString().length() > 0) {
                        notaTrabalho = Double.parseDouble(editNotaTrabalho.getText().toString());
                    } else {
                        editNotaTrabalho.setError("*");
                        editNotaTrabalho.requestFocus();
                        dadosValidados = false;
                    }

                    if(editMateria.getText().toString().length()==0){
                        editMateria.setError("*");
                        editMateria.requestFocus();
                        dadosValidados = false;
                    }

                    // Após Validação
                    if(dadosValidados) {
                        media = (notaProva + notaTrabalho) / 2;

                        txtResultado.setText(String.valueOf(media));

                        if (media >= 7) txtSituacaoFinal.setText("Aprovado");
                        else txtSituacaoFinal.setText("Reprovado");

                    }

                } catch (Exception e) {

                    Toast.makeText(getApplicationContext(), "Informe as notas...", Toast.LENGTH_LONG).show();

                }


            }
        });
    }
}