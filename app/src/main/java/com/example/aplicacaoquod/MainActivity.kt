package com.example.aplicacaoquod

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.aplicacaoquod.ui.theme.AplicacaoQuodTheme
import com.example.aplicacaoquod.screens.TelaInicial


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicacaoQuodTheme {
                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colorScheme.background){
                    LogoQuod()
                    //SimulacaoBiometria()
                    TelaInicial()

                }
            }
        }
    }
}

class Greeting(name: String, modifier: Modifier) {

}


@Composable
fun LogoQuod() {
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopStart
    ){
    Image(
        painter = painterResource(id = R.drawable.quodlogo1),
        contentDescription = "Logo do App",
        modifier = Modifier.size(150.dp).fillMaxSize().padding(start = 20.dp, bottom = 30.dp),
        contentScale = ContentScale.Fit, // Ajusta como a imagem será exibida

    )
    }
}
