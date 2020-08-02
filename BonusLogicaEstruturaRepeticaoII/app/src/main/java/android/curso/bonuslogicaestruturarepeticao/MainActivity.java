package android.curso.bonuslogicaestruturarepeticao;

import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

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

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
