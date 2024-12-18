package com.example.nighteventsapp.screens

import android.content.Context
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.example.nighteventsapp.models.eventList
import com.example.nighteventsapp.utils.sendNotification

@Composable
fun HomeScreen(navController: NavHostController, context: Context) {
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(eventList) { event ->
            Card(
                modifier = Modifier
                    .padding(8.dp)
                    .clickable { navController.navigate("eventDetails/${event.id}") },
                elevation = CardDefaults.cardElevation(4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Row(modifier = Modifier.fillMaxWidth()) {
                        Image(
                            painter = painterResource(id = event.imageRes),
                            contentDescription = "Imagem do evento",
                            modifier = Modifier
                                .size(64.dp)
                                .padding(end = 16.dp),
                            contentScale = ContentScale.Crop
                        )
                        Column(modifier = Modifier.weight(1f)) {
                            Text(text = event.title, style = MaterialTheme.typography.titleMedium)
                            Text(text = event.location, style = MaterialTheme.typography.bodySmall)
                        }
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    Row(horizontalArrangement = Arrangement.SpaceBetween) {
                        Button(
                            onClick = {
                                event.isFavorite.value = !event.isFavorite.value
                                val message = if (event.isFavorite.value) {
                                    "Evento adicionado aos favoritos!"
                                } else {
                                    "Evento removido dos favoritos!"
                                }
                                sendNotification(context, "Favorito", message)
                            }
                        ) {
                            Text(if (event.isFavorite.value) "Desfavoritar" else "Favoritar")
                        }
                        Button(
                            onClick = {
                                event.isSubscribed.value = !event.isSubscribed.value
                                val message = if (event.isSubscribed.value) {
                                    "Inscrição confirmada!"
                                } else {
                                    "Inscrição cancelada!"
                                }
                                sendNotification(context, "Inscrição", message)
                            }
                        ) {
                            Text(if (event.isSubscribed.value) "Cancelar inscrição" else "Inscrever-se")
                        }
                    }
                }
            }
        }
    }
}
