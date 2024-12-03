package com.example.aplicacaoquod.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.aplicacaoquod.R

@Composable
fun Biometria(navController: NavController) {
    var status by remember { mutableStateOf("Clique para autenticar") }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = status)

        Spacer(modifier = Modifier.height(20.dp))

        FilledTonalButton(
            onClick = {
                // Simulação de sucesso ou falha
                status = "Autenticando..."
                Handler(Looper.getMainLooper()).postDelayed({
                    status =
                        if (Math.random() > 0.5) "Autenticado com Sucesso!" else "Falha na Autenticação"
                }, 2000)
            },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)
        ) {
            Icon(
                painter = painterResource(id = R.drawable.baseline_fingerprint_24), // Substitua com o seu ícone
                contentDescription = "Biometria",
                modifier = Modifier.size(24.dp) // Tamanho do ícone
            )
            Spacer(modifier = Modifier.width(8.dp)) // Espaço entre a imagem e o texto
            Text(text = "Simulação de Biometria")
        }
        FilledTonalButton(
            onClick = { navController.navigate("screen1") },  // Navega de volta para a tela Escolha
            modifier = Modifier.width(350.dp).height(50.dp)
        ) {
            Text("Voltar para a Tela de Escolha")
        }
    }
}