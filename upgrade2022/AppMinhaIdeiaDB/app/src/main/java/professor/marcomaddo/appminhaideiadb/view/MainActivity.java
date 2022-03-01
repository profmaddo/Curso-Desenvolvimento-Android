package professor.marcomaddo.appminhaideiadb.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import professor.marcomaddo.appminhaideiadb.R;
import professor.marcomaddo.appminhaideiadb.api.AppUtil;
import professor.marcomaddo.appminhaideiadb.controller.ClienteController;
import professor.marcomaddo.appminhaideiadb.model.Cliente;

public class MainActivity extends AppCompatActivity {

    ClienteController clienteController;
    Cliente obj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d(AppUtil.TAG, "onCreate: App Minha Ideia DataBase");

        clienteController = new ClienteController(getApplicationContext());

      /*  for (int i = 0; i < 49; i++) {

            obj = new Cliente();

            obj.setNome("Marco Maddo "+i);
            obj.setEmail(i+"_maddo@teste.com.br");

            clienteController.incluir(obj);


        }*/

        for (Cliente obj: clienteController.listar()) {

            Log.e("Retorno", "onCreate: "+obj.getId()+" "+obj.getNome()+" "+obj.getEmail());

        }


    }
}