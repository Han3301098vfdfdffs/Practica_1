package com.example.practica_1.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.practica_1.viewmodel.MainViewModel

@Composable
fun TestAlgorithmScreen(
    viewModel: MainViewModel,
    n: Int,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier.padding(16.dp)) {
        Text(
            text = "Ejecución secuencial y concurrente:",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Button(
            onClick = { viewModel.calcularSuma(1) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { viewModel.calcularSuma(2) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar 2N")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { viewModel.calcularSuma(3) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar 3N")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { viewModel.calcularSuma(4) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar 4N")
        }
        Spacer(modifier = Modifier.height(8.dp))
        Button(
            onClick = { viewModel.calcularSuma(5) },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Sumar 5N")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = { viewModel.resetResultados() },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Borrar resultados")
        }
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Resultados:",
            modifier = Modifier.padding(bottom = 8.dp)
        )
        Text(text = "Suma lineal: ${viewModel.sumaLineal}")
        Text(text = "Suma acumulativa: ${viewModel.sumaAcumulativa}")
        Text(text = "Veces sumadas: ${viewModel.vecesSumadas}")
    }
}

@Preview
@Composable
fun TestAlgorithmScreenPreview() {
    val viewModel = MainViewModel()
    TestAlgorithmScreen(viewModel = viewModel, n = 1)
}
