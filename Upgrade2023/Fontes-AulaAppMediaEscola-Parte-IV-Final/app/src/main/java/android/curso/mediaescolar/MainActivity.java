package android.curso.mediaescolar;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

import java.text.DecimalFormat;

/**
 *
 * Esta é a versão final do aplicativo Média Escolar contendo
 * todos os conceitos estudados até o momento no curso.
 *
 * Nas próximas seções este aplicativo vai receber mais recursos
 * e uma nova arquitetura baseada no modelo MVC, além de persistência
 * dos dados no banco de dados SQLite.
 *
 * A versão final para este aplicativo no curso, será capaz de
 * salvar os dados no SQLite e enviar e receber os dados para a internet
 * utilizando um WebService escrito em PHP.
 * 
 */

public class MainActivity extends AppCompatActivity {

    Button btnPrimeiroBimestre;
    Button btnSegundoBimestre;
    Button btnTerceiroBimestre;
    Button btnQuartoBimestre;
    Button btnResultadoFinal;

    // SharedPreferences
    public static final String NOME_SHARED_PREFER = "mediaEscolarPref";

    String materiaPrimeiroBimestre, materiaSegundoBimestre,
            materiaTerceiroBimestre, materiaQuartoBimestre;

    String situacaoPrimeiroBimestre, situacaoSegundoBimestre,
            situacaoTerceiroBimestre, situacaoQuartoBimestre;

    String notaProvaPrimeiroBimestre, notaProvaSegundoBimestre,
            notaProvaTerceiroBimestre, notaProvaQuartoBimestre;

    String notaTrabalhoPrimeiroBimestre, notaTrabalhoSegundoBimestre,
            notaTrabalhoTerceiroBimestre, notaTrabalhoQuartoBimestre;

    String notaMediaPrimeiroBimestre, notaMediaSegundoBimestre,
            notaMediaTerceiroBimestre, notaMediaQuartoBimestre;

    boolean primeiroBimestre, segundoBimestre, terceiroBimestre,
            quartoBimestre;

    double mediaFinal;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lerSharedPreferences();

        btnPrimeiroBimestre = findViewById(R.id.btnPrimeiroBimestre);
        btnSegundoBimestre = findViewById(R.id.btnSegundoBimestre);
        btnTerceiroBimestre = findViewById(R.id.btnTerceiroBimestre);
        btnQuartoBimestre = findViewById(R.id.btnQuartoBimestre);
        btnResultadoFinal = findViewById(R.id.btnResultadoFinal);

        btnSegundoBimestre.setEnabled(primeiroBimestre);
        btnTerceiroBimestre.setEnabled(segundoBimestre);
        btnQuartoBimestre.setEnabled(terceiroBimestre);

        btnPrimeiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, PrimeiroBimestreActivity.class);
                startActivity(i);
            }
        });

        btnSegundoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, SegundoBimestreActivity.class);
                startActivity(i);
            }
        });

        btnTerceiroBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, TerceiroBimestreActivity.class);
                startActivity(i);
            }
        });

        btnQuartoBimestre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, QuartoBimestreActivity.class);
                startActivity(i);
            }
        });

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Limpando todos os registros...", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

                clearSharedPreferences();

            }
        });

        visualizarResultado();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {

        int id = item.getItemId();


        if (id == R.id.action_sair) {

            finish();

            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onResume()
    {
        super.onResume();

        lerSharedPreferences();
        visualizarResultado();

    }

    private void lerSharedPreferences()
    {

        SharedPreferences mediaEscolarPref = getSharedPreferences(NOME_SHARED_PREFER, 0);

        materiaPrimeiroBimestre = mediaEscolarPref.getString("materiaPrimeiroBimestre", "");
        materiaSegundoBimestre = mediaEscolarPref.getString("materiaSegundoBimestre", "");
        materiaTerceiroBimestre = mediaEscolarPref.getString("materiaTerceiroBimestre", "");
        materiaQuartoBimestre = mediaEscolarPref.getString("materiaQuartoBimestre", "");

        situacaoPrimeiroBimestre = mediaEscolarPref.getString("situacaoPrimeiroBimestre", "");
        situacaoSegundoBimestre = mediaEscolarPref.getString("situacaoSegundoBimestre", "");
        situacaoTerceiroBimestre = mediaEscolarPref.getString("situacaoTerceiroBimestre", "");
        situacaoQuartoBimestre = mediaEscolarPref.getString("situacaoQuartoBimestre", "");

        notaProvaPrimeiroBimestre = mediaEscolarPref.getString("notaProvaPrimeiroBimestre", "");
        notaProvaSegundoBimestre = mediaEscolarPref.getString("notaProvaSegundoBimestre", "");
        notaProvaTerceiroBimestre = mediaEscolarPref.getString("notaProvaTerceiroBimestre", "");
        notaProvaQuartoBimestre = mediaEscolarPref.getString("notaProvaQuartoBimestre", "");

        notaTrabalhoPrimeiroBimestre = mediaEscolarPref.getString("notaTrabalhoPrimeiroBimestre", "0.0");
        notaTrabalhoSegundoBimestre = mediaEscolarPref.getString("notaTrabalhoSegundoBimestre", "0.0");
        notaTrabalhoTerceiroBimestre = mediaEscolarPref.getString("notaTrabalhoTerceiroBimestre", "0.0");
        notaTrabalhoQuartoBimestre = mediaEscolarPref.getString("notaTrabalhoQuartoBimestre", "0.0");

        notaMediaPrimeiroBimestre = mediaEscolarPref.getString("notaMediaPrimeiroBimestre", "0.0");
        notaMediaSegundoBimestre = mediaEscolarPref.getString("notaMediaSegundoBimestre", "0.0");
        notaMediaTerceiroBimestre = mediaEscolarPref.getString("notaMediaTerceiroBimestre", "0.0");
        notaMediaQuartoBimestre = mediaEscolarPref.getString("notaMediaQuartoBimestre", "0.0");

        primeiroBimestre = mediaEscolarPref.getBoolean("primeiroBimestre", false);
        segundoBimestre = mediaEscolarPref.getBoolean("segundoBimestre", false);
        terceiroBimestre = mediaEscolarPref.getBoolean("terceiroBimestre", false);
        quartoBimestre = mediaEscolarPref.getBoolean("quartoBimestre", false);


    }

    private void visualizarResultado()
    {
        if (primeiroBimestre) {
            // TODO: Criar método para montar o texto de apresentação
            btnPrimeiroBimestre.setText(materiaPrimeiroBimestre+" - 1º Bimestre " + situacaoPrimeiroBimestre + " - Nota " + formatarValorDecimal(Double.parseDouble(notaMediaPrimeiroBimestre)));
            btnPrimeiroBimestre.setEnabled(false);
            btnSegundoBimestre.setEnabled(primeiroBimestre);
        }

        if (segundoBimestre) {
            btnSegundoBimestre.setText(materiaSegundoBimestre+" - 2º Bimestre " + situacaoSegundoBimestre + " - Nota " + formatarValorDecimal(Double.parseDouble(notaMediaSegundoBimestre)));
            btnSegundoBimestre.setEnabled(false);
            btnTerceiroBimestre.setEnabled(segundoBimestre);
        }

        if (terceiroBimestre) {
            btnTerceiroBimestre.setText(materiaTerceiroBimestre+" - 3º Bimestre " + situacaoTerceiroBimestre + " - Nota " + formatarValorDecimal(Double.parseDouble(notaMediaTerceiroBimestre)));
            btnTerceiroBimestre.setEnabled(false);
            btnQuartoBimestre.setEnabled(terceiroBimestre);
        }

        if (quartoBimestre) {
            btnQuartoBimestre.setText(materiaQuartoBimestre+" - 4º Bimestre " + situacaoQuartoBimestre + " - Nota " + formatarValorDecimal(Double.parseDouble(notaMediaQuartoBimestre)));
            btnQuartoBimestre.setEnabled(false);
            btnResultadoFinal.setEnabled(true);

            mediaFinal = 0;
            mediaFinal += Double.parseDouble(notaMediaPrimeiroBimestre);
            mediaFinal += Double.parseDouble(notaMediaSegundoBimestre);
            mediaFinal += Double.parseDouble(notaMediaTerceiroBimestre);
            mediaFinal += Double.parseDouble(notaMediaQuartoBimestre);

            String mensagemFinal = "";

            mediaFinal = (mediaFinal / 4);

            if((Double.parseDouble(notaMediaPrimeiroBimestre)>=7)
                    && (Double.parseDouble(notaMediaSegundoBimestre)>=7)
                    && (Double.parseDouble(notaMediaTerceiroBimestre)>=7)
                    && (Double.parseDouble(notaMediaQuartoBimestre)>=7))
            {

                // condição == algo ? faço isso : ou faço isso

                mensagemFinal  = mediaFinal >= 7 ?
                        "Aprovado com Média Final " + formatarValorDecimal(mediaFinal) :
                        "Reprovado com Média Final " + formatarValorDecimal(mediaFinal);


            }else {

                mensagemFinal  = "Reprovado por matéria com Média Final " + formatarValorDecimal(mediaFinal);

            }


            btnResultadoFinal.setText(mensagemFinal);

        }
    }

    private void clearSharedPreferences()
    {
        SharedPreferences mediaEscolarPref = getSharedPreferences(NOME_SHARED_PREFER, 0);
        SharedPreferences.Editor editor = mediaEscolarPref.edit();
        editor.clear();
        editor.commit();

        clearMenu();

    }

    private void clearMenu()
    {

        btnResultadoFinal.setEnabled(false);
        btnQuartoBimestre.setEnabled(false);
        btnTerceiroBimestre.setEnabled(false);
        btnSegundoBimestre.setEnabled(false);
        btnPrimeiroBimestre.setEnabled(true);

        btnResultadoFinal.setText("Resultado Final");
        btnPrimeiroBimestre.setText("1º Bimestre");
        btnSegundoBimestre.setText("2º Bimestre");
        btnTerceiroBimestre.setText("3º Bimestre");
        btnQuartoBimestre.setText("4º Bimestre");
    }

    public static String formatarValorDecimal(Double valor)
    {
        DecimalFormat df = new DecimalFormat("#,###,##0.00");
        return df.format(valor);
    }


}