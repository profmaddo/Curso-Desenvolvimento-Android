package android.curso.aulaappsendsms;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * <p>Esta classe inicializa o app SMS<p/>
 *
 * @author marcomaddo
 *
 */

public class MainActivity extends AppCompatActivity {

    // Classe nativa do SDK Android para Envio do SMS
    SmsManager objSmsManager;

    Button btnEnviar;
    EditText editSMSPara;
    EditText editSMSMensagem;

    // objetos auxiliares
    String SMSPara;
    String SMSMensagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnEnviar = findViewById(R.id.btnEnviar);
        editSMSPara = (EditText) findViewById(R.id.editSMSPara);
        editSMSMensagem = (EditText) findViewById(R.id.editSMSMensagem);

        btnEnviar.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                SMSPara = editSMSPara.getText().toString();
                SMSMensagem = editSMSMensagem.getText().toString();

                // Necessário Try Catch para controle de erros
                try {

                    // Classe SmsManager

                    objSmsManager = SmsManager.getDefault();

                    // Método sendTextMessage utilizado para o envio
                    // do SMS. Requer dois parâmetros:
                    // - SMSPara - número do celular destinatário
                    // - SMSMensagem - Texto do SMS
                    objSmsManager.sendTextMessage(SMSPara,
                            null, SMSMensagem,
                            null, null);

                    showAlerta(
                            "Seu SMS foi enviado com sucesso!", 1);

                } catch (Exception e) {

                    showAlerta(
                            "Tente novamente, ocorreu uma falha ao enviar o SMS.", 1);

                    e.printStackTrace();
                }

            }
        });



    }


    /**
     *
     * @param mensagem
     * @param codigo
     */
    public void showAlerta(String mensagem, int codigo){

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setMessage(mensagem)
                .setNegativeButton("Voltar", null)
                .create()
                .show();

    }
}
