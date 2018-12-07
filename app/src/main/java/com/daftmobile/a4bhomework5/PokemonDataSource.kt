package com.daftmobile.a4bhomework5

interface PokemonDataSource {
    fun fetch(index: String,
              onSuccess: (PokemonItem) -> Unit,
              onError: (String) -> Unit)
}