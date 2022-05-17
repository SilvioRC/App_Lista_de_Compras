package com.example.app_lista_de_compras
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*
import kotlinx.android.synthetic.main.activity_main.*
import org.w3c.dom.Text
import java.util.*
import java.text.NumberFormat
import java.util.Locale


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val produtosAdapter = ProdutoAdapter(this)
        //val lsvProdutos = findViewById<ListView>(R.id.lsvProdutos)
        val txtProduto = findViewById<EditText>(R.id.txtProduto)
        val listViewProdutos = findViewById<ListView>(R.id.listViewProdutos)
        val btnAdicionar = findViewById<Button>(R.id.btnInserir)
        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        //val btnInserir = findViewById<Button>(R.id.btnAdicionar)


        //val mercadoAdapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_2)
        listViewProdutos.adapter = produtosAdapter

        btnAdicionar.setOnClickListener {
            var intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        listViewProdutos.setOnItemClickListener { adapterView: AdapterView<*>, view, position: Int, id ->
            val item = produtosAdapter.getItem(position)
            produtosAdapter.remove(item)

            var soma = 0.0

            for (item in produtosGlobal) {
                soma += item.valor * item.quantidade
            }
            val f= NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            txtTotal.text= "Total: ${f.format(soma)}"
        }

    }
        override fun onResume()  {
            super.onResume()

            val adapter = lsvProdutos.adapter as ProdutoAdapter

            adapter.clear()
            adapter.addAll(produtosGlobal)

            var soma = 0.0

            for(item in produtosGlobal){
                soma += item.valor * item.quantidade
            }
            val f = NumberFormat.getCurrencyInstance(Locale("pt", "b"))
            txtTotal.text = "Total: ${f.format(soma)}"


        }

    }






