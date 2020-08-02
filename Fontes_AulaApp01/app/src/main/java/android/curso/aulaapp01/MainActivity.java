package android.curso.aulaapp01;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Componente TextView utilizado para apresentar mensagens texto
    TextView txtTitulo;

    // Componente EditText utilizado para receber dados digitados
    EditText primeiroNome, segundoNome, telefone, email;

    // Componente Button utilizado para executar ações diversas
    Button btnLimpar, btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Método setContentView utilizado para setar qual Layout
        // será utilizado para a Activity, no caso R.layout.actibity_main
        setContentView(R.layout.activity_main);

        initFormulario();

        // Método setOnClickListner utilizado para receber o click
        // no botão e executar alguma ação ou regra de negócio
        btnLimpar.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                initCampos();
            }
        });

        btnSalvar.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showMensagem();

            }
        });


    }

    private void initCampos() {

        primeiroNome.setText("");
        segundoNome.setText("");
        telefone.setText("");
        email.setText("");
    }

    private void showMensagem() {
        // Classe Toast utilizada para apresentar mensagens
        // curtas na tela do celular semelhante aos PopUps
        Toast.makeText(getApplicationContext(),"Primeiro nome: "+primeiroNome.getText(),Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Segundo nome: "+segundoNome.getText(),Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Telefone: "+telefone.getText(),Toast.LENGTH_LONG).show();
        Toast.makeText(getApplicationContext(),"Email: "+email.getText(),Toast.LENGTH_LONG).show();
    }

    private void initFormulario() {
        // Método findViewById utilizado para linkar o componente
        // de Layout com a classe MainActivity neste caso
        primeiroNome = findViewById(R.id.primeiroNome);
        segundoNome = findViewById(R.id.segundoNome);
        telefone = findViewById(R.id.telefone);
        email = findViewById(R.id.email);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
    }
}
