package com.example.practica_1.viewmodel

import android.os.SystemClock
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

class MainViewModel: ViewModel() {


    var countTime by mutableStateOf(0)
        private set
    var countTime2 by mutableStateOf(0)
        private set

    var isCounterFinished by mutableStateOf(false)
        private set

    private var counterJob1: Job? = null

    private suspend fun counter1(){
        for (i in 1..6){
            delay(1000)
            countTime = i
        }
    }
    private suspend fun counter2(){
        for (i in 1..2){
            delay(1000)
            countTime2 = i
        }
    }

    private fun counter3(){
        for (i in 1..6){
            Thread.sleep(1000)
            countTime = i
        }
    }
    fun goCounter(){
        countTime = 0
        counter3()
    }
    fun startCounter()
    {
        isCounterFinished = false
        counterJob1?.cancel()
        counterJob1 = viewModelScope.launch {
            countTime = 0
            countTime2 = 0

            counter1()
            counter2()

            delay(1000)

            countTime = 0
            countTime2 = 0
            isCounterFinished = true
        }
    }
    fun cancelarCounter(){
        counterJob1?.cancel()
        counterJob1 =  null
        countTime = 0
        countTime2 = 0
    }
    //SUMA

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