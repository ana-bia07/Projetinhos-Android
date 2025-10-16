package com.example.calculodeaposentadoria

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val spnSexo = findViewById<Spinner>(R.id.spn_sexo)
        val txtIdade = findViewById<EditText>(R.id.txt_Idade)
        val txtContribuicao = findViewById<EditText>(R.id.txt_Contribuição)
        val btnCalcular = findViewById<Button>(R.id.btn_Calcular)
        val txtResultado = findViewById<TextView>(R.id.txt_Resultado)

        spnSexo.adapter = ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item,
        listOf("Masculino", "Feminino"))

        btnCalcular.setOnClickListener {
            val sexo = spnSexo.selectedItem as String
            val idade = txtIdade.text.toString()
            val contribuicao = txtContribuicao.text.toString().toInt()

            if(idade.isBlank()) {
                txtResultado.text = "Digite sua idade"
                return@setOnClickListener
            } else {
                val idade = idade.toInt()
                if (idade > 100) {
                    txtResultado.text = "Idade Inválida"
                } else {
                    val resultado: Int
                    var resultContribuicao: Int
                    if (sexo == "Masculino") {
                        resultado = 65 - idade
                        resultContribuicao = 35 - contribuicao
                    } else {
                        resultado = 60 - idade
                        resultContribuicao = 30 - contribuicao
                    }
                    if (resultado <= 0 && resultContribuicao <= 0 ) {
                        txtResultado.text = "Parabéns você ja pode se aposentar"
                    } else {
                        txtResultado.text = "Faltam $resultado anos e $resultContribuicao anos de contribuição para sua aposentadoria."
                    }
                }
            }
        }
    }
}