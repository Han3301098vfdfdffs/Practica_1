package com.example.practica_1.data

import com.example.practica_1.R
import com.example.practica_1.model.Titulo

class DataSource() {
    fun LoadTitulos(): List<Titulo>{
        return listOf<Titulo>(
            Titulo(R.string.Tit1 , R.drawable.imagen1),
            Titulo(R.string.Tit2 , R.drawable.imagen2),
            Titulo(R.string.Tit3 , R.drawable.imagen3),
            Titulo(R.string.Tit4 , R.drawable.imagen4),
            Titulo(R.string.Tit5, R.drawable.imagen5),
            Titulo(R.string.Tit6, R.drawable.imagen6),
        )
    }
}