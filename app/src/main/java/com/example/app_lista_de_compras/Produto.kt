package com.example.app_lista_de_compras

import android.graphics.Bitmap

data class Produto(val nome: String,
                   val quantidade: Int,
                   val valor:Double,
                   val foto:Bitmap? = null)

