package android.curso.aulaappsendsms;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


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
                            "Seu SMS foi enviado com sucesso!");

                } catch (Exception e) {

                    showAlerta(
                            "Tente novamente, ocorreu uma falha ao enviar o SMS.");

                    e.printStackTrace();
                }

            }
        });



    }

    /*
    * Este recurso ainda não foi abordado até este momento
    * do curso, mas será explicado em detalhes em breve.
    * Apenas não altere este método.
     */
    public void showAlerta(String mensagem){

        android.app.AlertDialog.Builder builder = new android.app.AlertDialog.Builder(MainActivity.this);
        builder.setMessage(mensagem)
                .setNegativeButton("Voltar", null)
                .create()
                .show();

    }
}
