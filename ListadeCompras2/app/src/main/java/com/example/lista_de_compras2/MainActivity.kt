package com.example.lista_de_compras2

import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

data class Produto(val nome: String, val preco: Double) {
    // Sobrescreve o toString para que o ArrayAdapter saiba como exibir o item na lista
    override fun toString(): String {
        // Formata o preço para R$ X,XX
        val df = DecimalFormat("R$ #,##0.00")
        val precoFormatado = df.format(preco)
        return "$nome - $precoFormatado"
    }
}

class MainActivity : AppCompatActivity() {
    private var totalCompra: Double = 0.0

    private val df = DecimalFormat("R$ #,##0.00")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        val txtProduto = findViewById<EditText>(R.id.txt_Produto)
        val txtPreco = findViewById<EditText>(R.id.txt_Preco)
        val btnInserir = findViewById<Button>(R.id.btn_Inserir)
        val listCompras = findViewById<ListView>(R.id.list_Compras)
        val txtTotal = findViewById<TextView>(R.id.txt_Total)

        //criando adaptador
        val produtosAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1)
        listCompras.adapter = produtosAdapter

        fun atualizarTotal(){
            txtTotal.text = "Total: ${df.format(totalCompra)}"
        }

        atualizarTotal()

        btnInserir.setOnClickListener {
            val nome = txtProduto.text.toString()
            val preco = txtPreco.text.toString()
            if(nome.isEmpty()){
                txtProduto.error = "Digite o nome do produto"
            } else if (preco.isEmpty()){
                txtPreco.error = "Digite o prelo do produto"
            } else {
                val precoDouble = preco.toDouble()
                val novoProduto = Produto(nome, precoDouble)

                produtosAdapter.add(novoProduto.toString())

                totalCompra += precoDouble
                atualizarTotal()

                txtPreco.text.clear()
                txtProduto.text.clear()
            }
        }
        listCompras.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id: Long ->
            val produtoRemover = produtosAdapter.getItem(position)
            if (produtoRemover != null) {
                val preco = produtoRemover.split(" - ")[1].replace("R$", "").trim().toDouble()
                totalCompra -= preco
                atualizarTotal()
                produtosAdapter.remove(produtoRemover)
            }
        }
    }
}
