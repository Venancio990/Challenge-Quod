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
fun AutenticacaoCadastralSimulacao(navController: NavController) {
    // Estados para armazenar os dados do formulário
    var cpf by remember { mutableStateOf("") }
    var nome by remember { mutableStateOf("") }
    var endereco by remember { mutableStateOf("") }
    var telefone by remember { mutableStateOf("") }
    var statusValidacao by remember { mutableStateOf("Preencha os campos para validação.") }
    var isLoading by remember { mutableStateOf(false) }

    // Função para validar os dados
    val validarCadastro = {
        if (cpf.isEmpty() || nome.isEmpty() || endereco.isEmpty() || telefone.isEmpty()) {
            statusValidacao = "Por favor, preencha todos os campos."
        } else {
            isLoading = true
            statusValidacao = "Validando informações..."
            // Simulação de validação com atraso
            Handler(Looper.getMainLooper()).postDelayed({
                isLoading = false
                val sucesso = Math.random() > 0.3 // Resultado aleatório, 70% de chance de sucesso
                statusValidacao = if (sucesso) {
                    "Autenticação bem-sucedida! Bem-vindo, $nome!"
                } else {
                    "Erro na autenticação. Verifique os dados inseridos."
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
        // Campo para CPF
        OutlinedTextField(
            value = cpf,
            onValueChange = { cpf = it },
            label = { Text("CPF") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )

        // Campo para Nome
        OutlinedTextField(
            value = nome,
            onValueChange = { nome = it },
            label = { Text("Nome Completo") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )

        // Campo para Endereço
        OutlinedTextField(
            value = endereco,
            onValueChange = { endereco = it },
            label = { Text("Endereço") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )

        // Campo para Telefone
        OutlinedTextField(
            value = telefone,
            onValueChange = { telefone = it },
            label = { Text("Telefone Celular") },
            modifier = Modifier.fillMaxWidth().padding(8.dp),
            singleLine = true
        )

        Spacer(modifier = Modifier.height(16.dp))

        // Botão para validar os dados
        FilledTonalButton(
            onClick = { validarCadastro() },
            modifier = Modifier.fillMaxWidth().padding(8.dp).width(350.dp).height(50.dp),
            enabled = !isLoading
        ) {
            Text(if (isLoading) "Validando..." else "Validar Cadastro")
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Exibição do status da validação
        Text(
            text = statusValidacao,
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
