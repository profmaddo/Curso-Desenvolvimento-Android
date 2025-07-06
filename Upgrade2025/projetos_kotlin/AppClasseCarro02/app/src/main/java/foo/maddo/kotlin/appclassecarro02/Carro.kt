package foo.maddo.kotlin.appclassecarro02

import android.util.Log

data class Carro(
    var fabricante: String = "",
    var modelo: String = "",
    var ano: String = "",
    var cor: String = ""
) {
    init {
        Log.i("Carro", "Carro criado: $this")
    }
}
