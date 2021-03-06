package com.example.app_lista_de_compras

import android.view.LayoutInflater
import android.view.View
import android.widget.ArrayAdapter
import java.text.FieldPosition
import android.content.Context
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import java.util.Locale
import java.text.NumberFormat

class ProdutoAdapter(contexto:Context) : ArrayAdapter<Produto>(contexto,0) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup):
            View {
        val v: View
        if (convertView != null) {
            v = convertView
        } else {
            v = LayoutInflater.from(context).inflate(R.layout.list_view_item, parent, false)
        }
        val item = getItem(position)
        val txtProduto = v.findViewById<TextView>(R.id.txtItemProduto)
        val txtQtde = v.findViewById<TextView>(R.id.txtItemQtde)
        val txtValor = v.findViewById<TextView>(R.id.txtItemValor)
        val imgProduto = v.findViewById<ImageView>(R.id.imgItemFoto)

        txtQtde.text = item?.quantidade.toString()
        txtProduto.text = item?.nome
        txtValor.text = item?.valor.toString()
         val f = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        txtValor.text = f.format(item?.valor)
        if (item?.foto != null) {
            imgProduto.setImageBitmap(item?.foto)

        }
        return v
    }
}

