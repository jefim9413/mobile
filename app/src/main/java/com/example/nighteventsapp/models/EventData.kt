package com.example.nighteventsapp.models

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import com.example.nighteventsapp.R

data class Event(
    val id: Int,
    val title: String,
    val description: String,
    val date: String,
    val location: String,
    val isFavorite: MutableState<Boolean> = mutableStateOf(false),
    val isSubscribed: MutableState<Boolean> = mutableStateOf(false),
    val imageRes: Int
)

val eventList = listOf(
    Event(
        id = 1,
        title = "Conferência de Tecnologia 2024",
        description = "Explore o futuro da tecnologia e inovação.",
        date = "2024-12-14",
        location = "Parque Tecnológico",
        imageRes = R.drawable.img1
    ),
    Event(
        id = 2,
        title = "Festival de Startups",
        description = "Descubra as ideias revolucionárias das startups.",
        date = "2024-06-20",
        location = "Centro de Inovação",
        imageRes = R.drawable.img2
    ),
    Event(
        id = 3,
        title = "Festival de Música 2024",
        description = "Os melhores shows de música em um só lugar.",
        date = "2024-08-05",
        location = "Estádio Municipal",
        imageRes = R.drawable.img3
    ),
    Event(
        id = 4,
        title = "Gala de Ciência e Tecnologia",
        description = "Um evento exclusivo para amantes da ciência.",
        date = "2024-09-10",
        location = "Palácio de Convenções",
        imageRes = R.drawable.img4
    ),
    Event(
        id = 5,
        title = "Empreendedorismo e Negócios",
        description = "Aprenda com os maiores líderes empresariais.",
        date = "2024-07-12",
        location = "Auditório Central",
        imageRes = R.drawable.img5
    ),
    Event(
        id = 6,
        title = "Feira Literária 2024",
        description = "Explore o mundo dos livros e da leitura.",
        date = "2024-10-01",
        location = "Biblioteca Nacional",
        imageRes = R.drawable.img6
    ),
    Event(
        id = 7,
        title = "Exposição de Arte Moderna",
        description = "Arte contemporânea em sua melhor forma.",
        date = "2024-11-05",
        location = "Galeria de Arte Contemporânea",
        imageRes = R.drawable.img7
    ),
    Event(
        id = 8,
        title = "Workshop de Fotografia",
        description = "Aprenda técnicas avançadas de fotografia.",
        date = "2024-04-18",
        location = "Estúdio Fotográfico",
        imageRes = R.drawable.img8
    ),
    Event(
        id = 9,
        title = "Hackathon de Tecnologia",
        description = "Resolva desafios e crie soluções inovadoras.",
        date = "2024-03-20",
        location = "Campus Universitário",
        imageRes = R.drawable.img9
    ),
    Event(
        id = 10,
        title = "Festival Gastronômico",
        description = "Saboreie as melhores comidas e bebidas.",
        date = "2024-05-30",
        location = "Praça Central",
        imageRes = R.drawable.img10
    )
)
