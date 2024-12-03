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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@Composable
fun SimulacaoAnaliseDeDocumento(navController: NavController) {
    // Estados para controlar o progresso da simulação
    var documentoCapturado by remember { mutableStateOf(false) }
    var faceCapturada by remember { mutableStateOf(false) }
    var statusValidacao by remember { mutableStateOf("Aguardando captura...") }

    // Função para simular a captura do documento
    val capturarDocumento = {
        documentoCapturado = true
        statusValidacao = "Documento capturado com sucesso!"
    }

    // Função para simular a captura da face
    val capturarFace = {
        faceCapturada = true
        statusValidacao = "Foto da face capturada com sucesso!"
    }

    // Função para simular a validação
    val validarCapturas = {
        if (documentoCapturado && faceCapturada) {
            statusValidacao = "Validando capturas..."
            Handler(Looper.getMainLooper()).postDelayed({
                statusValidacao = if (Math.random() > 0.5) "Validação bem-sucedida!" else "Falha na validação!"
            }, 2000)
        } else {
            statusValidacao = "Capture ambos: documento e face!"
        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Exibe o status da simulação
        Text(
            text = statusValidacao,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(8.dp)
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para capturar documento
        FilledTonalButton(
            onClick = { capturarDocumento() },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)
        ) {
            Text("Capturar Documento")
        }

        // Botão para capturar face
        FilledTonalButton(
            onClick = { capturarFace() },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)
        ) {
            Text("Capturar Face")
        }

        // Botão para validar as capturas
        FilledTonalButton(
            onClick = { validarCapturas() },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)
        ) {
            Text("Validar Capturas")
        }

        // Indicador visual para capturas (pode substituir por imagens reais)
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Documento: ${if (documentoCapturado) "✅ Capturado" else "❌ Não Capturado"}",
            style = MaterialTheme.typography.bodyMedium
        )
        Text(
            text = "Face: ${if (faceCapturada) "✅ Capturada" else "❌ Não Capturada"}",
            style = MaterialTheme.typography.bodyMedium
        )
        FilledTonalButton(
            onClick = { navController.navigate("screen1") },  // Navega de volta para a tela Escolha
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)
        ) {
            Text("Voltar para a Tela de Escolha")
        }
    }

}
