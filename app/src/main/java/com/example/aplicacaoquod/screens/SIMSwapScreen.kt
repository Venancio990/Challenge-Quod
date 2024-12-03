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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SimulacaoSIMSwap(navController: NavController) {
    var telefone by remember { mutableStateOf("") }
    var statusConsulta by remember { mutableStateOf("Insira o número para verificar o SIM SWAP.") }
    var isLoading by remember { mutableStateOf(false) }

    // Função para simular a consulta ao endpoint
    val verificarSIMSwap = {
        if (telefone.isEmpty()) {
            statusConsulta = "Por favor, insira um número de telefone."
        } else {
            isLoading = true
            statusConsulta = "Consultando..."
            // Simula uma chamada ao endpoint com atraso
            Handler(Looper.getMainLooper()).postDelayed({
                isLoading = false
                val sucesso = Math.random() > 0.5 // Resultado aleatório
                statusConsulta = if (sucesso) {
                    "SIM SWAP detectado recentemente para o número $telefone!"
                } else {
                    "Nenhuma troca de chip detectada para o número $telefone."
                }
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
        // Campo de entrada para o número de telefone
        OutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it },
            label = { Text("Número de Telefone") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para verificar SIM SWAP
        FilledTonalButton(
            onClick = { verificarSIMSwap() },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp),
            enabled = !isLoading
        ) {
            Text(if (isLoading) "Consultando..." else "Verificar SIM SWAP")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exibição do status da consulta
        Text(
            text = statusConsulta,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.padding(8.dp),
            textAlign = TextAlign.Center
        )
        FilledTonalButton(
            onClick = { navController.navigate("screen1") },  // Navega de volta para a tela Escolha
            modifier = Modifier.width(350.dp).height(50.dp)
        ) {
            Text("Voltar para a Tela de Escolha")
        }

    }
}
