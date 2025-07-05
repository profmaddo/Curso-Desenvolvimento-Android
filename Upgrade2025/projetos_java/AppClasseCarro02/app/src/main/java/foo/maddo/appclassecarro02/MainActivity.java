package foo.maddo.appclassecarro02;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Carro novoCarro;

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

        novoCarro = new Carro();
        novoCarro.setModelo("Fusca");
        novoCarro.setFabricante("VW");
        novoCarro.setAno("1965");
        novoCarro.setCor("Vermelho");

        System.out.println(novoCarro.getModelo());
        System.out.println(novoCarro.getFabricante());
        System.out.println(novoCarro.getAno());
        System.out.println(novoCarro.getCor());


        Log.i("Carro", novoCarro.getModelo());
        Log.i("Carro", novoCarro.getFabricante());
        Log.i("Carro", novoCarro.getAno());
        Log.i("Carro", novoCarro.getCor());
        Log.i("Carro", novoCarro.toString());

    }
}