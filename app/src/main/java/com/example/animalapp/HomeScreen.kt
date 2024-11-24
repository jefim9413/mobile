package com.example.animalapp

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert


@ExperimentalMaterial3Api
@Composable
fun HomeScreen(onAnimalSelected: (String) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("AnimalApp") },
                actions = { AnimalAppMenu(onOptionSelected = onAnimalSelected) }
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues), // Corrigido para usar paddingValues
            contentAlignment = Alignment.Center
        ) {
            Text("Selecione um animal no menu.")
        }
    }
}

@Composable
fun AnimalAppMenu(onOptionSelected: (String) -> Unit) {
    var expanded by remember { mutableStateOf(false) }
    IconButton(onClick = { expanded = true }) {
        Icon(Icons.Default.MoreVert, contentDescription = null)
    }
    DropdownMenu(
        expanded = expanded,
        onDismissRequest = { expanded = false }
    ) {
        DropdownMenuItem(
            text = { Text("Dog") },
            onClick = {
                expanded = false
                onOptionSelected("Dog")
            }
        )
        DropdownMenuItem(
            text = { Text("Cat") },
            onClick = {
                expanded = false
                onOptionSelected("Cat")
            }
        )
    }
}
