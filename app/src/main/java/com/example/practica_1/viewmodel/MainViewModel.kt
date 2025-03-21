package com.example.practica_1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel


class MainViewModel: ViewModel() {
    var sumaLineal by mutableStateOf(0)
        private set
    var sumaAcumulativa by mutableStateOf(0)
        private set
    var vecesSumadas by mutableStateOf(0)
        private set

    fun calcularSuma(multiplier: Int) {
        sumaLineal = 1 + 2  // Siempre 3, sin importar el botón presionado.
        sumaAcumulativa += 5 * multiplier
        vecesSumadas += multiplier
    }
    fun resetResultados() {
        sumaLineal = 0
        sumaAcumulativa = 0
        vecesSumadas = 0
    }
}