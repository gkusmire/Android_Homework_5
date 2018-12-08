package com.daftmobile.a4bhomework5

import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonFetcher: PokemonDataSource {
    private val gson = GsonBuilder()
            .setLenient()
            .create()

    private val client = OkHttpClient.Builder()
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://switter.app.daftmobile.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

    private val pokemonApi = retrofit.create(PokemonApi::class.java)

    override fun fetch(index: String, onSuccess: (PokemonItem) -> Unit, onError: (String) -> Unit) {

        val call = pokemonApi.getPokemonByIndex(index)

        call.enqueue(object : Callback<PokemonItem> {

            override fun onFailure(call: Call<PokemonItem>, t: Throwable) {
                onError(t.message ?: "No message")
            }

            override fun onResponse(call: Call<PokemonItem>, response: Response<PokemonItem>) {
                if (response.isSuccessful) {

                    onSuccess(PokemonItem(response.body()?.index ?: "",
                            response.body()?.name ?: "",
                            response.body()?.backgroundColor ?: 101))


                } else {
                    onError("Serwer zwrócił: ${response.code()}")
                }
            }
        })
    }
}