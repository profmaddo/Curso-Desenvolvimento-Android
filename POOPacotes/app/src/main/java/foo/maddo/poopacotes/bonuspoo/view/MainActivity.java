package foo.maddo.poopacotes.bonuspoo.view;

import android.content.Context;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import foo.maddo.poopacotes.R;
import foo.maddo.poopacotes.bonuspoo.model.Carro;

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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        context = getApplicationContext();

        editFabricante = findViewById(R.id.editFabricante);
        editModelo = findViewById(R.id.editModelo);
        editAno = findViewById(R.id.editAno);
        editCor = findViewById(R.id.editCor);

        chkPartida = findViewById(R.id.chkPartida);
        chkFarol = findViewById(R.id.chkFarol);

        imgCarro = findViewById(R.id.imgCarro);

        chkFarol.setOnClickListener(v -> {

            if (chkFarol.isChecked()) {
                imgCarro.setImageResource(R.drawable.farois);
                Toast.makeText(getApplicationContext(), "Farol Ligado", Toast.LENGTH_LONG).show();
            } else {
                imgCarro.setImageResource(R.drawable.carro);
                Toast.makeText(getApplicationContext(), "Farol desligado", Toast.LENGTH_LONG).show();
            }
        });

        chkPartida.setOnClickListener(v -> {

            objCarro = new Carro();

            objCarro.setFabricante(editFabricante.getText().toString());
            objCarro.setModelo(editModelo.getText().toString());
            objCarro.setAno(editAno.getText().toString());
            objCarro.setCor(editCor.getText().toString());

            fabricarCarro();

            if (chkPartida.isChecked()) {

                imgCarro.setImageResource(R.drawable.motor);
                Toast.makeText(getApplicationContext(), "Motor Ligado", Toast.LENGTH_LONG).show();


            } else {
                imgCarro.setImageResource(R.drawable.carro);
                Toast.makeText(getApplicationContext(), "Motor desligado", Toast.LENGTH_LONG).show();
            }

        });

    }


    public void fabricarCarro() {

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(this);
        builder.setMessage("Fabricante: " + objCarro.getFabricante() + "\nModelo: " + objCarro.getModelo() + "\nAno: " + objCarro.getAno() + "\nCor: " + objCarro.getCor())
                .setNegativeButton("Objeto Carro Criado", null)
                .create()
                .show();


        //.setMessage("Fabricante: "+objCarro.getFabricante()+"\nModelo: "+objCarro.getModelo()+"\nAno: "+objCarro.getAno()+"\nCor: "+objCarro.getCor())

    }
}