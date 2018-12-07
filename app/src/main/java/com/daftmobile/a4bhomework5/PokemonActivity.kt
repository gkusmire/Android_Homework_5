package com.daftmobile.a4bhomework5

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_pokemon.*

class PokemonActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pokemon)

        val pokemon = getPokemonInfo()
        showPokemonInfo(pokemon)
    }

    private fun getPokemonInfo(): PokemonItem{
        return intent.getParcelableExtra<PokemonItem>("pokemon")
    }

    private fun showPokemonInfo(pokemon: PokemonItem){
        setPokemonName(pokemon.name)
        setPokemonId(pokemon.index)
        setPokemonBackground(pokemon.backgroundColor)
    }

    private fun setPokemonBackground(backgroundColor: Int) {
       colorView.setBackgroundColor(backgroundColor)
    }

    private fun setPokemonId(index: String) {
        numberView.text = "#${index}"
    }

    private fun setPokemonName(name: String) {
        nameView.text = name
    }


}
