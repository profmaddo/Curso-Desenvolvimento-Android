package foo.maddo.appaula02classesdebug;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Pessoa pessoa;
    Button btnFabricarObjetoPessoa;
    TextView txtPessoa;
    int contagem = 0;
    int eventos = 0;

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

        txtPessoa = findViewById(R.id.txtPessoa);
        btnFabricarObjetoPessoa = findViewById(R.id.btnFabricarObjetoPessoa);

        btnFabricarObjetoPessoa.setOnClickListener(v -> { fabricaPessoa(); });


        // Exemplo de uso da classe Pessoa

        fabricaPessoa();
        metodoParaCriarPessoa();
        metodoParaAlterarPessoa();
        metodoParaDeletarPessoa();
        metodoParaListarPessoa();


    }

    private void metodoParaListarPessoa() {
        eventos++;
        txtPessoa.setText(pessoa.getNome() + " " + pessoa.getIdade()+" - "+contagem+"ª Pessoas");
        Log.i("eventos","Total de eventos: "+eventos+" - Listagem");


    }

    private void metodoParaDeletarPessoa() {
        eventos++;
        txtPessoa.setText(pessoa.getNome() + " " + pessoa.getIdade()+" - "+contagem+"ª Pessoas");
        Log.v("eventos","Total de eventos: "+eventos+" - Deletar");
    }

    private void metodoParaAlterarPessoa() {
        eventos++;
        txtPessoa.setText(pessoa.getNome() + " " + pessoa.getIdade()+" - "+contagem+"ª Pessoas");
        Log.d("eventos","Total de eventos: "+eventos+" - Alterar");

    }

    private void metodoParaCriarPessoa() {
        eventos++;
        txtPessoa.setText(pessoa.getNome() + " " + pessoa.getIdade()+" - "+contagem+"ª Pessoas");
        Log.e("eventos","Total de eventos: "+eventos+" - Criar");

    }


    private void fabricaPessoa() {

        int idade = getIdade();
        contagem++;
        pessoa = new Pessoa("Marco", idade);
        txtPessoa.setText(pessoa.getNome() + " " + pessoa.getIdade()+" - "+contagem+"ª Pessoas");
    }

    private static int getIdade() {
        Random idadeAleatoria = new Random();
        int min = 18;
        int max = 50;
        int idade = idadeAleatoria.nextInt(max - min + 1) + min;
        return idade;
    }


}