package com.example.zooapp.models

import com.example.zooapp.R

data class Animal(
    val id: Int,
    val name: String,
    val species: String,
    val imageRes: Int,
    val description: String,
    val curiosities: String,
    var isFavorite: Boolean = false
)

val animalList = listOf(
    Animal(
        id = 1,
        name = "Dog",
        species = "Canis lupus familiaris",
        imageRes = R.drawable.doc,
        description = "O cão é um dos animais mais antigos domesticados pelo homem.",
        curiosities = "Os cães têm um olfato cerca de 40 vezes mais potente que o dos humanos."
    ),
    Animal(
        id = 2,
        name = "Cat",
        species = "Felis catus",
        imageRes = R.drawable.cat,
        description = "O gato doméstico é conhecido por sua agilidade e independência.",
        curiosities = "Gatos passam cerca de 70% do dia dormindo."
    ),
    Animal(
        id = 3,
        name = "Elephant",
        species = "Loxodonta africana",
        imageRes = R.drawable.elephant,
        description = "Elefantes são os maiores animais terrestres.",
        curiosities = "Seus ouvidos grandes ajudam a regular a temperatura corporal."
    ),
    Animal(
        id = 4,
        name = "Penguin",
        species = "Spheniscidae",
        imageRes = R.drawable.penguin,
        description = "Os pinguins são aves que não voam, adaptadas para a vida aquática.",
        curiosities = "Eles podem passar até 75% do tempo na água."
    ),
    Animal(
        id = 5,
        name = "Lion",
        species = "Panthera leo",
        imageRes = R.drawable.lion,
        description = "Os leões são conhecidos como os 'reis da selva'.",
        curiosities = "Eles podem dormir até 20 horas por dia."
    ),
    Animal(
        id = 6,
        name = "Kangaroo",
        species = "Macropus",
        imageRes = R.drawable.kangaroo,
        description = "Os cangurus são marsupiais nativos da Austrália.",
        curiosities = "Podem saltar até três vezes o comprimento do corpo."
    ),
    Animal(
        id = 7,
        name = "Parrot",
        species = "Psittaciformes",
        imageRes = R.drawable.parrot,
        description = "Os papagaios são aves coloridas e muito inteligentes.",
        curiosities = "Alguns podem imitar sons humanos."
    ),
    Animal(
        id = 8,
        name = "Dolphin",
        species = "Delphinidae",
        imageRes = R.drawable.dolphin,
        description = "Os golfinhos são mamíferos marinhos altamente inteligentes.",
        curiosities = "Eles se comunicam com assobios e cliques."
    )
)

