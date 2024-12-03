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
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController


@Composable
fun ScoreAntifraude(navController: NavController) {
    var cpf by remember { mutableStateOf("") }
    var score by remember { mutableStateOf<Int?>(null) }
    var statusConsulta by remember { mutableStateOf("Insira um CPF para calcular o score antifraude.") }
    var isLoading by remember { mutableStateOf(false) }

    // Função para simular a consulta ao score antifraude
    val calcularScore = {
        if (cpf.isEmpty() || cpf.length != 11) {
            statusConsulta = "Por favor, insira um CPF válido (11 dígitos)."
        } else {
            isLoading = true
            statusConsulta = "Calculando score..."
            Handler(Looper.getMainLooper()).postDelayed({
                isLoading = false
                score = (1..1000).random() // Gera um score aleatório
                statusConsulta = "O score para o CPF $cpf foi calculado."
            }, 2000) // Simula um atraso de 2 segundos
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Campo para entrada de CPF
        OutlinedTextField(
            value = cpf,
            onValueChange = {
                if (it.length <= 11 && it.all { char -> char.isDigit() }) {
                    cpf = it
                }
            },
            label = { Text("CPF") },
            placeholder = { Text("Digite seu CPF (somente números)") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para calcular o score
        FilledTonalButton(
            onClick = { calcularScore() },
            modifier = Modifier.width(350.dp).height(50.dp),
            enabled = !isLoading
        ) {
            Text(if (isLoading) "Calculando..." else "Calcular Score")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exibição do status da consulta
        Text(
            text = statusConsulta,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))


        if (score != null) {
            Text(
                text = "Score Antifraude: $score",
                style = MaterialTheme.typography.headlineSmall,
                color = if (score!! > 800) Color.Green else if (score!! > 400) Color.Yellow else Color.Red,
                modifier = Modifier.padding(8.dp)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para voltar à tela de escolha
        FilledTonalButton(
            onClick = { navController.navigate("screen1") },
            modifier = Modifier.width(350.dp).height(50.dp)
        ) {
            Text("Voltar para a Tela de Escolha")
        }
    }
}
