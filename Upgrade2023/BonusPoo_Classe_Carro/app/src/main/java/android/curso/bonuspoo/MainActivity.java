package android.curso.bonuspoo;

import android.content.Context;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

/**
 * Created by marcomaddo on 26/10/2017.
 * Atualizado para Android Studio 3.5.2 em 25/11/2019
 */

public class MainActivity extends AppCompatActivity {

    EditText editFabricante;
    EditText editModelo;
    EditText editAno;
    EditText editCor;
    CheckBox chkPartida;
    CheckBox chkFarol;
    ImageView imgCarro;

    Carro objCarro;

    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        context = getApplicationContext();

        initFormulario();

        chkFarol.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(chkFarol.isChecked()){
                    imgCarro.setImageResource(R.drawable.farois);
                    Toast.makeText(getApplicationContext(),"Farol Ligado",Toast.LENGTH_LONG).show();
                }else{
                    imgCarro.setImageResource(R.drawable.carro);
                    Toast.makeText(getApplicationContext(),"Farol desligado",Toast.LENGTH_LONG).show();
                }
            }
        });

        chkPartida.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                objCarro = new Carro();

                objCarro.setFabricante(editFabricante.getText().toString());
                objCarro.setModelo(editModelo.getText().toString());
                objCarro.setAno(editAno.getText().toString());
                objCarro.setCor(editCor.getText().toString());

                fabricarCarro();

                if(chkPartida.isChecked()){

                    imgCarro.setImageResource(R.drawable.motor);
                    Toast.makeText(getApplicationContext(),"Motor Ligado",Toast.LENGTH_LONG).show();


                }else{
                    imgCarro.setImageResource(R.drawable.carro);
                    Toast.makeText(getApplicationContext(),"Motor desligado",Toast.LENGTH_LONG).show();
                }

            }
        });

    }

    private void initFormulario() {
        editFabricante = findViewById(R.id.editFabricante);
        editModelo = findViewById(R.id.editModelo);
        editAno = findViewById(R.id.editAno);
        editCor = findViewById(R.id.editCor);

        chkPartida = findViewById(R.id.chkPartida);
        chkFarol = findViewById(R.id.chkFarol);

        imgCarro = findViewById(R.id.imgCarro);
    }


    public void fabricarCarro(){

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setMessage("Fabricante: "+objCarro.getFabricante()+"\nModelo: "+objCarro.getModelo()+"\nAno: "+objCarro.getAno()+"\nCor: "+objCarro.getCor())
                .setNegativeButton("Objeto Carro Criado", null)
                .create()
                .show();


                //.setMessage("Fabricante: "+objCarro.getFabricante()+"\nModelo: "+objCarro.getModelo()+"\nAno: "+objCarro.getAno()+"\nCor: "+objCarro.getCor())

    }
}
