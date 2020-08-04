package android.curso.mediaescolar;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;

import java.text.DecimalFormat;

/**
 * Esta versão do aplicativo Média Escolar demonstra
 * o conceito de Ciclo de Vida de uma Activity
 *
 * https://developer.android.com/guide/components/activities/activity-lifecycle.html
 *
 */
public class MainActivity extends AppCompatActivity {

    Button btnPrimeiroBimestre;
    Button btnSegundoBimestre;
    Button btnTerceiroBimestre;
    Button btnQuartoBimestre;
    Button btnResultadoFinal;


    // status dos menus, ativado ou desativado
    boolean primeiroBimestre,
            segundoBimestre,
            terceiroBimestre,
            quartoBimestre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        Log.i("MediaEscolar","----> onCreate()");


        btnPrimeiroBimestre = findViewById(R.id.btnPrimeiroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTerceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);
        btnResultadoFinal = findViewById(R.id.btnResultadoFinal);

        btnPrimeiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela =
                        new Intent(MainActivity.this,
                                PrimeiroBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnSegundoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela =
                        new Intent(MainActivity.this,
                                SegundoBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnTerceiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela =
                        new Intent(MainActivity.this,
                                TerceiroBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnQuartoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent proximaTela =
                        new Intent(MainActivity.this,
                                QuartoBimestreActivity.class);
                startActivity(proximaTela);

            }
        });

        btnResultadoFinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplication(), "Resultado Final", Toast.LENGTH_SHORT).show();
            }
        });


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Limpar todos os dados", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                clearSharedPreferences();
            }
        });

        Log.i("MediaEscolar", "Activity entrou no onCreate()");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        Log.i("MediaEscolar","----> onCreatedOptionsMenu()");

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        Log.i("MediaEscolar","----> ononOptionsItemSelected()");

        int id = item.getItemId();


        if (id == R.id.action_sair) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onStart() {
        super.onStart();

    }

    @Override
    public void onResume() {
        super.onResume();

        Log.i("MediaEscolar","----> onResume()");

        // significa bimestre fechado
        primeiroBimestre = true;

        if(primeiroBimestre) {
            btnPrimeiroBimestre.setEnabled(false);
            btnSegundoBimestre.setEnabled(true);
            btnPrimeiroBimestre.setText(" ***** FECHADO *****");
        }

    }

    @Override
    public void onPause() {
        super.onPause();
        Log.i("MediaEscolar","----> onPause()");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i("MediaEscolar","----> onStop()");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i("MediaEscolar","----> onDestroy()");
    }


    private void salvarSharedPreferences() {
    }


    /**
     * Recuperar os dados salvos com os valores
     * das notas de cada bimestre
     */
    private void lerSharedPreferences() {
    }

    /**
     * Apagar todos os dados salvos e deixar o
     * aplictivo pronto para novos cálculos
     */
    private void clearSharedPreferences() {
    }

    /**
     * Controle das opções do menu e visualização
     * dos resultados com base nos dados recuperados
     */
    private void visualizarResultado() {
    }

    /**
     * Resetar o menu, voltando os mesmos ao status
     * inicial, ou seja, apenas com a primeira opção
     * liberada
     */
    private void clearMenu() {
    }

    /**
     * Formatar os números para duas casas decimais
     *
     * @param valor
     * @return
     */
    public static String formatarValorDecimal(Double valor) {

        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);

    }


}
