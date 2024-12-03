package com.example.aplicacaoquod.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController


@Composable
fun Escolha(navController: NavController) {
    Column {
        FilledTonalButton(onClick = { navController.navigate("screen2") },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)) {
            Text("Biometria")
        }
        FilledTonalButton(onClick = { navController.navigate("screen3") },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)) {
            Text("Biometria Facial")
        }
        FilledTonalButton(onClick = { navController.navigate("screen4") },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)) {
            Text("Analise Documentos")
        }
        FilledTonalButton(onClick = { navController.navigate("screen5") },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)) {
            Text("SIM Swap")
        }
        FilledTonalButton(onClick = { navController.navigate("screen6") },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)) {
            Text("Autenticação Cadastral")
        }
        FilledTonalButton(onClick = { navController.navigate("screen7") },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)) {
            Text("Veja seu Score!")
        }
    }
}

@Composable
fun TelaInicial() {
    val navController = rememberNavController()
    Column(
        modifier = Modifier
            .padding(horizontal = 10.dp, vertical = 90.dp)
            .clip(shape = RoundedCornerShape(20.dp))
            .background(Color(0, 181, 208)),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Bem-Vindo a seleção de demonstração Antifraude, por favor selecione uma opção a seguir",
            modifier = Modifier.padding(top = 30.dp, bottom = 50.dp),
            textAlign = TextAlign.Center,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            lineHeight = 1.em
        )


        NavHost(navController = navController, startDestination = "screen1") {
            composable("screen1") {
                Escolha(navController = navController)
            }
            composable("screen2") {
                Biometria(navController = navController)
            }
            composable("screen3") {
                BiometriaFacial(navController = navController)
            }
            composable("screen4") {
                SimulacaoAnaliseDeDocumento(navController = navController)
            }
            composable("screen5") {
                SimulacaoSIMSwap(navController = navController)
            }
            composable("screen6") {
                AutenticacaoCadastralSimulacao(navController = navController)
            }
            composable("screen7") {
                ScoreAntifraude(navController = navController)
            }
        }
    }




}


