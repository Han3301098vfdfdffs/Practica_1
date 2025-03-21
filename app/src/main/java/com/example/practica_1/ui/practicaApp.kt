package com.example.practica_1.ui

import android.media.Image
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import com.example.practica_1.R
import com.example.practica_1.data.DataSource
import com.example.practica_1.model.Titulo
import com.example.practica_1.viewmodel.MainViewModel

@Composable
fun ImagesCard(viewModel: MainViewModel,titulo: Titulo, modifier: Modifier = Modifier){
    var changeButton by remember{
        mutableStateOf(false)
    }
    var changeColor by remember {
        mutableStateOf(false)
    }
    LaunchedEffect(viewModel.countTime2) {
        if (viewModel.isCounterFinished) changeButton = false
    }
    Card(modifier = Modifier.padding(16.dp)){
        Row(verticalAlignment = Alignment.CenterVertically){
            Column(
                modifier = Modifier.weight(0.45f).padding(10.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Image(
                    painter = painterResource(id = titulo.drawableResourceId),
                    contentDescription = stringResource(id = titulo.stringResourceId),
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
            Column(
                modifier = Modifier.weight(0.6f).padding(10.dp)
            ){
                Text("${viewModel.countTime} [s]")
                Spacer(modifier = Modifier.height(30.dp))
                Text("${viewModel.countTime2} [s]")
                Spacer(modifier = Modifier.height(30.dp))
                Button(onClick = {
                    if(!changeButton) viewModel.startCounter() else viewModel.cancelarCounter()
                    changeButton = !changeButton},
                    modifier = Modifier.size(width = 150.dp, height = 50.dp),
                    colors = ButtonDefaults.buttonColors(
                        if(changeButton) {
                            Color.Red}  else Color.Green),
                ) {
                    Text(text = if(changeButton) "Cancelar" else "Iniciar")
                }
            }
        }
    }
}

@Composable
fun CardList(titulos: List<Titulo>, modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier) {
        items(titulos.indices.toList()){ index ->
            ImagesCard(
                viewModel = MainViewModel(),
                titulo = titulos[index],
                modifier= Modifier.padding(24.dp)
            )
        }
    }
}


@Preview(showBackground = true)
@Composable
fun ImagesCard_Preview(){
    val dataSource = DataSource()
    val titulos = dataSource.LoadTitulos()
    ImagesCard(viewModel = MainViewModel(),titulo = titulos[0])
}
