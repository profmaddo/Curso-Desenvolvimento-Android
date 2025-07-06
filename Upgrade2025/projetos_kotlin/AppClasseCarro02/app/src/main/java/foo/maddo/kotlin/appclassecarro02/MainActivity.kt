package foo.maddo.kotlin.appclassecarro02

import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    private lateinit var novoCarro: Carro // Usando lateinit para inicialização posterior

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Criando e configurando o objeto Carro
        novoCarro = Carro(
            fabricante = "VW",
            modelo = "Fusca",
            ano = "1965",
            cor = "Vermelho"
        )

        // Acessando propriedades
        Log.i("Carro_Kotlin", "Fabricante: ${novoCarro.fabricante}")
        Log.i("Carro_Kotlin", "Modelo: ${novoCarro.modelo}")
        Log.i("Carro_Kotlin", "Ano: ${novoCarro.ano}")
        Log.i("Carro_Kotlin", "Cor: ${novoCarro.cor}")

        // O Log no init da classe Carro já terá sido chamado
        // E o toString() gerado pela data class é usado automaticamente aqui:
        Log.i("Carro_Kotlin", "Detalhes do Carro: $novoCarro")
    }
}