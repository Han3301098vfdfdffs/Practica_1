package com.example.practica_1.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    var resultState by mutableStateOf("")
        private set

    var countTime by mutableStateOf(0)
        private set
    var countTime2 by mutableStateOf(0)
        private set
    var countTime3 by mutableStateOf(0)
        private set

    var isCounterFinished by mutableStateOf(false)
        private set

    private var counterJob1: Job? = null
    private var counterJob2: Job? = null

    private suspend fun counter1(){
        for (i in 1..3){
            delay(1000)
            countTime = i
        }
    }
    private suspend fun counter2(){
        for (i in 1..8){
            delay(1000)
            countTime2 = i
        }
    }

    private suspend fun counter3(){
        resultState = ""
        for (i in 1..5){
            delay(1000)
            countTime3 = i
        }
        resultState = "Respuesta obtenida de la web"
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
    fun fetchData(){
        counterJob2?.cancel()
        counterJob2 = viewModelScope.launch {
            countTime3 = 0
            counter3()
        }
    }

    //Esta función bloquea
//    fun bloqueoApp(){
//        Thread.sleep(5000)
//        resultState = "Respuesta obtenida de la web"
//    }

}