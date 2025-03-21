package com.example.practica_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica_1.ui.theme.Practica_1Theme
import com.example.practica_1.viewmodel.MainViewModel
import com.example.practica_1.ui.TestAlgorithmScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: MainViewModel by viewModels()
            Practica_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    // Se reemplaza ImageCard por TestAlgorithmScreen para probar las ejecuciones
                    TestAlgorithmScreen(
                        viewModel = viewModel,
                        n = 1, // Define el valor de N según lo que necesites
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun TestAlgorithmScreenPreview() {
    val viewModel = MainViewModel()
    TestAlgorithmScreen(viewModel = viewModel, n = 1, modifier = Modifier.padding(16.dp))
}
