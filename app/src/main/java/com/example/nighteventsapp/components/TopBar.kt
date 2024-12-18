package com.example.nighteventsapp.components

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.BrightnessHigh
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.Composable

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(
    onThemeToggle: () -> Unit,
    onOpenDrawer: () -> Unit
) {
    TopAppBar(
        title = { Text("EventsApp") },
        navigationIcon = {
            IconButton(onClick = onOpenDrawer) {
                Icon(Icons.Default.Menu, contentDescription = "Abrir menu")
            }
        },
        actions = {
            IconButton(onClick = onThemeToggle) {
                Icon(Icons.Default.BrightnessHigh, contentDescription = "Alternar tema")
            }
        }
    )
}
