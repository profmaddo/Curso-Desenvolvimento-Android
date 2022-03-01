package foo.daazi.appfonteexternatruetype;

import android.graphics.Typeface;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

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
        setContentView(R.layout.activity_main);

        txtMariaLucia =  findViewById(R.id.txtMariaLucia);

        Typeface TTFMariaLucia = Typeface.createFromAsset(getAssets(),
                pasta+fontTTFMariaLucia);
        txtMariaLucia.setTypeface(TTFMariaLucia);

        txtRiscoRabisco =  findViewById(R.id.txtRiscoRabisco);

        Typeface TTFRiscoRabisco = Typeface.createFromAsset(getAssets(),
                pasta+fontTTFRiscoRabisco);
        txtRiscoRabisco.setTypeface(TTFRiscoRabisco);

        btnAnjaEliane =  findViewById(R.id.btnAnjaEliane);

        Typeface TTFAnjaEliane = Typeface.createFromAsset(getAssets(),
                pasta+fontTTFAnjaEliane);
        btnAnjaEliane.setTypeface(TTFAnjaEliane);

    }
}
