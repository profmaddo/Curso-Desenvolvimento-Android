package foo.maddo.appminhaideiadb.view;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import foo.maddo.appminhaideiadb.R;
import foo.maddo.appminhaideiadb.api.AppUtil;
import foo.maddo.appminhaideiadb.controller.ClienteController;
import foo.maddo.appminhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente obj;


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
        Log.d(AppUtil.TAG, "onCreate: App Minha Ideia DataBase");

        clienteController = new ClienteController(getApplicationContext());

         for (int i = 0; i < 49; i++) {

            obj = new Cliente();

            obj.setNome("Marco Maddo "+i);
            obj.setEmail(i+"_maddo@teste.com.br");

            clienteController.incluir(obj);


        }

        for (Cliente obj: clienteController.listar()) {

            Log.e("Retorno", "onCreate: "+obj.getId()+" "+obj.getNome()+" "+obj.getEmail());

        }
    }
}