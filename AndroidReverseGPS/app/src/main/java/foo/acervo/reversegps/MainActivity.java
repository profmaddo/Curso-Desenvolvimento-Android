package foo.acervo.reversegps;

import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // TODO: Classe GPSTracker
    GPSTracker gps;
    TextView txtLatitude, txtLongitude, txtEndereco, txtRede;
    Button btnMapa;

    Geocoder geocoder;

    String urlMapa = "http://maps.google.com/maps?q=0.0,0.0";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtLatitude =  findViewById(R.id.txtLatitude);
        txtLongitude =   findViewById(R.id.txtLongitude);
        txtEndereco =   findViewById(R.id.txtEndereco);
        btnMapa =   findViewById(R.id.btnMapa);

        Log.i("GpsReverso", AppUtil.getNetworkClass(this));

        txtRede = (TextView) findViewById(R.id.txtRede);
        txtRede.setText("Origem - Rede : " + AppUtil.getNetworkClass(this));

        gps = new GPSTracker(this);

        geocoder = new Geocoder(this);

        if (gps.canGetLocation()) {

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            if (AppUtil.isConnectingToInternet(getApplicationContext()) && (latitude != 0) && (longitude != 0)) {

                List<Address> geoResult = getEnderecoReverso(latitude, longitude);

                Address enderecoAtual = geoResult.get(0);

                String tempo = "";

                if (enderecoAtual.getAddressLine(0) != null)
                    tempo += "\n " + enderecoAtual.getAddressLine(0);

                if (enderecoAtual.getAddressLine(1) != null)
                    tempo += "\n " + enderecoAtual.getAddressLine(1);

                if (enderecoAtual.getAddressLine(2) != null)
                    tempo += "\n " + enderecoAtual.getAddressLine(2);

                if (enderecoAtual.getAdminArea() != null)
                    tempo += "\n " + enderecoAtual.getAdminArea();


                txtEndereco.setVisibility(View.VISIBLE);
                txtEndereco.setText(tempo);


                txtLatitude.setText("Latitude: " + String.valueOf(latitude));

                txtLongitude.setText("Longitude: " + String.valueOf(longitude));


                btnMapa.setEnabled(true);

                urlMapa = "http://maps.google.com/maps?q=" + String.valueOf(latitude) + "," + String.valueOf(longitude);

            } else {

                Toast.makeText(this, "Coordenadas não disponíveis, verifique as permissões para o aplicativo....", Toast.LENGTH_LONG).show();
                btnMapa.setEnabled(false);

            }

        }

        btnMapa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlMapa));
                startActivity(browserIntent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            finish();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private List<Address> getEnderecoReverso(Double lat, Double lon) {

        final int maxResults = 10;

        List<Address> enderecos = null;

        try {
            enderecos = geocoder.getFromLocation(lat, lon, maxResults);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }

        return enderecos;
    }

}
