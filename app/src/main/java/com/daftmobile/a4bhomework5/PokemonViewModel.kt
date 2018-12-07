package com.daftmobile.a4bhomework5

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel

class PokemonViewModel: ViewModel() {
    private val pokemonDataSource: PokemonDataSource = PokemonFetcher()

    private val pokemonLiveData = SingleLiveEvent<PokemonItem>()
    private val errorLiveData = SingleLiveEvent<String>()

    fun newPokemon(): LiveData<PokemonItem> = pokemonLiveData
    fun error(): LiveData<String> = errorLiveData

    fun showPokemonInfo(index: String) {
        pokemonDataSource.fetch(index,
                {pokemonLiveData.value = it},
                {errorLiveData.value = it})
    }
}
