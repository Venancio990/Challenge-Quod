package com.example.aplicacaoquod.screens

import android.os.Handler
import android.os.Looper
import androidx.compose.foundation.Image
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
fun BiometriaFacial(navController: NavController) {
    var status by remember { mutableStateOf("Clique para iniciar a captura de face") }
    var showFaceCapture by remember { mutableStateOf(false) } // Controla o início da captura
    var validationStatus by remember { mutableStateOf("") } // Status da validação

    // Função para simular a validação após a captura
    val simulateFaceCaptureAndValidation = {
        showFaceCapture = true
        status = "Capturando face..."
        Handler(Looper.getMainLooper()).postDelayed({
            // Após um tempo de "captura", validação ocorre
            validationStatus =
                if (Math.random() > 0.5) "Sucesso na validação!" else "Falha na validação"
            status = validationStatus
            showFaceCapture = false
        }, 2000) // Simulando o tempo de captura de 2 segundos
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // Exibe a mensagem de status
        Text(text = status)

        Spacer(modifier = Modifier.height(20.dp))

        // Se estiver simulando captura de face, mostre uma imagem ou animação
        if (showFaceCapture) {
            Image(
                painter = painterResource(id = R.drawable.face_capture_image), // Substitua com sua imagem de captura
                contentDescription = "Captura de Face",
                modifier = Modifier.size(200.dp)
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        // Botão para iniciar a simulação
        FilledTonalButton(
            onClick = {
                simulateFaceCaptureAndValidation()
            }, modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp)
        ) {
            Text("Iniciar Simulação de Captura de Face")
        }
        FilledTonalButton(
            onClick = { navController.navigate("screen1") },  // Navega de volta para a tela Escolha
            modifier = Modifier.width(350.dp).height(50.dp)
        ) {
            Text("Voltar para a Tela de Escolha")
        }
    }

}