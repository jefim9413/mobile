package com.example.nighteventsapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
@Composable
fun DrawerContent(navController: NavHostController, onCloseDrawer: () -> Unit) {
    Surface(
        modifier = Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.surface) // Fundo sólido para o drawer
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Menu",
                style = MaterialTheme.typography.titleMedium,
                modifier = Modifier.padding(bottom = 16.dp)
            )
            Divider(modifier = Modifier.padding(vertical = 8.dp))
            Text(
                text = "Perfil",
                modifier = Modifier
                    .clickable {
                        onCloseDrawer()
                        // Navegar para a tela de perfil (se implementada)
                    }
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Notificações",
                modifier = Modifier
                    .clickable {
                        onCloseDrawer()
                        navController.navigate("notifications")
                    }
                    .padding(vertical = 8.dp)
            )
            Text(
                text = "Sair",
                color = MaterialTheme.colorScheme.error,
                modifier = Modifier
                    .clickable {
                        onCloseDrawer()
                        // Implementar lógica de logout
                    }
                    .padding(vertical = 8.dp)
            )
            Spacer(modifier = Modifier.weight(1f))
            Text(
                text = "Versão 1.0.0",
                modifier = Modifier.padding(vertical = 8.dp)
            )
        }
    }
}
