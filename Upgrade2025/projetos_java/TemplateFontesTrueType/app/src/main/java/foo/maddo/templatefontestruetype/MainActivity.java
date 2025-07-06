package foo.maddo.templatefontestruetype;

import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    TextView txtRiscoRabisco;
    TextView txtMariaLucia;
    Button btnAnjaEliane;

    // Resource assets
    // Nome da pasta com as fontes
    String pasta = "fonts/";
    String fontTTFAnjaEliane = "Anja_Eliane.ttf";
    String fontTTFMariaLucia = "Maria_lucia.ttf";
    String fontTTFRiscoRabisco = "risco_rabisco.ttf";



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
    }
}