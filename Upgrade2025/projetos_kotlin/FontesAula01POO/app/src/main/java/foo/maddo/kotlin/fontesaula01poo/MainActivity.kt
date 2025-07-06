package foo.maddo.kotlin.fontesaula01poo

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.*
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat


class MainActivity : AppCompatActivity() {

    var primeiroNome: EditText? = null
    var segundoNome: EditText? = null
    var telefone: EditText? = null
    var email: EditText? = null
    var btnLimpar: Button? = null
    var btnSalvar: Button? = null

    var contato: Contato? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        primeiroNome = findViewById(R.id.primeiroNome)
        segundoNome = findViewById(R.id.segundoNome)
        telefone = findViewById(R.id.telefone)
        email = findViewById(R.id.email)

        btnLimpar = findViewById(R.id.btnLimpar)
        btnSalvar = findViewById(R.id.btnSalvar)

        btnLimpar?.setOnClickListener(View.OnClickListener {
            limpar()
        })
        btnSalvar?.setOnClickListener(View.OnClickListener {
            salvar()
        })


    }

    fun limpar() {
        primeiroNome?.setText("")
        segundoNome?.setText("")
        telefone?.setText("")
        email?.setText("")
    }

    fun salvar() {
        contato = Contato()
        contato?.primeiroNome = primeiroNome?.text.toString()
        contato?.segundoNome = segundoNome?.text.toString()
        contato?.telefone = telefone?.text.toString()
        contato?.email = email?.text.toString()
        Toast.makeText(this, "Contato salvo com sucesso!", Toast.LENGTH_SHORT).show()
    }
}
