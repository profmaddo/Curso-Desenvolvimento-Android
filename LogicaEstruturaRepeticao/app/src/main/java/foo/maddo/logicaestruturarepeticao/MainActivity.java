package foo.maddo.logicaestruturarepeticao;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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

        List<String> linguagens = new ArrayList<>();


        popularLista(linguagens);

        // Primeira opção..: for
        // Segunda opção...: foreach
        // Terceira opção..: while (condição) { }
        // Quarta opção....: do {  } while (condição)

        for (int i = 0; i < linguagens.size(); i++){
            Log.i("CursoAndroid","For: "+linguagens.get(i).toString());
        }

        for (String linguagem: linguagens){
            Log.w("CursoAndroid","Foreach: "+linguagem);
        }

        int x = 10;
        while (x < linguagens.size())  {
            Log.i("CursoAndroid","While: "+linguagens.get(x).toString());
            x++;
        }

        int y = 0;
        do {
            Log.w("CursoAndroid","do While: "+linguagens.get(y).toString());
            y = 10;
        } while (y < linguagens.size());


    }

    private void popularLista(List<String> linguagens) {

        linguagens.add("Java");
        linguagens.add("JavaScript");
        linguagens.add("PHP");
        linguagens.add("C");
        linguagens.add("C++");
        linguagens.add("Prolog");
        linguagens.add("Pascal");
    }
}