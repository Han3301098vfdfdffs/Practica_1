package com.example.practica_1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.DatePicker
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.practica_1.ui.theme.Practica_1Theme
import com.example.practica_1.data.DataSource
import com.example.practica_1.ui.CardList
import com.example.practica_1.ui.ImagesCard
import com.example.practica_1.viewmodel.MainViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel:MainViewModel by viewModels()
            Practica_1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    ImageCard(
                        modifier =Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun ImageCard(modifier: Modifier){
    CardList(
        titulos = DataSource().LoadTitulos()
    )
}