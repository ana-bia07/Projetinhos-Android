package com.example.ano_mes_dia

import android.os.Bundle
import android.view.ViewDebug
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.LruCache
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.time.LocalDate

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val spnTipoConversao = findViewById<Spinner>(R.id.spn_TipoConversao)
        val txtAniversario = findViewById<EditText>(R.id.txt_Aniversario)
        val txtResult = findViewById<TextView>(R.id.txt_Result)
        val btnConverte = findViewById<Button>(R.id.btn_Conversao)

        spnTipoConversao.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
            listOf("Converter para Dias", "Converter para Meses", "Converter para Anos"))

        btnConverte.setOnClickListener {

            if(txtAniversario.text.isEmpty()){
                txtAniversario.error = "Digite a sua idade em anos"
            } else {
                val aniversariotxt = txtAniversario.text.toString()
                val aniversario = aniversariotxt.split("/")


                val anoAni = aniversario[2].toInt()
                val mesAni = aniversario[1].toInt()
                val diaAni = aniversario[0].toInt()
                val result: Int

                val anoAtual = LocalDate.now().year
                val mesAtual = LocalDate.now().monthValue
                val diaAtual = LocalDate.now().dayOfMonth
                val diferencaA = if (anoAtual >= anoAni) {
                    anoAtual - anoAni
                } else {
                    anoAni - anoAtual
                }
                val diferencaM = if (mesAtual >= mesAni) {
                    mesAtual - mesAni
                } else {
                    mesAni - mesAtual
                }
                val diferencaD = if (diaAtual >= diaAni) {
                    diaAtual - diaAni
                } else {
                    diaAni - diaAtual
                }

                val tipoConversao = spnTipoConversao.selectedItem as String

                if (tipoConversao == "Converter para Dias") {
                    result = diferencaA * 360 + diferencaM * 30 + diferencaD
                    txtResult.text = "Você tem $result dias de vida!"
                } else if (tipoConversao == "Converter para Meses") {
                    result = diferencaA * 12 + diferencaM + diferencaD / 30
                    txtResult.text = "Você tem $result meses de vida!"

                } else {
                    result = diferencaA + ((diferencaM + diferencaD / 30) / 12)
                    txtResult.text = "Você tem $result anos de vida!"
                }
            }
           }

    }
}