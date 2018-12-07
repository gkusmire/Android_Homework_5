package com.daftmobile.a4bhomework5

import android.provider.Settings
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonFetcher: PokemonDataSource {
    private val gson = Gson()
    private val client = OkHttpClient.Builder()
            .build()

    private val retrofit = Retrofit.Builder()
            .client(client)
            .baseUrl("https://switter.app.daftmobile.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    private val pokemonApi = retrofit.create(PokemonApi::class.java)

    override fun fetch(index: String, onSuccess: (PokemonItem) -> Unit, onError: (String) -> Unit) {

        val call = pokemonApi.getPokemonByIndex(index)

        call.enqueue(object : Callback<PokemonItem> {

            override fun onFailure(call: Call<PokemonItem>, t: Throwable) {
//                onError(t.message ?: "No message")
                onError("ASD")
            }

            override fun onResponse(call: Call<PokemonItem>, response: Response<PokemonItem>) {
                if (response.isSuccessful && response.body() != null) {
//                    var pokemon = gson.fromJson(response.body().toString(), PokemonItem::class.java)
//
//                    onSuccess(pokemon)

                    onSuccess(PokemonItem(response.body().toString(), "", 11))



                } else {
                    onError("Serwer zwrócił: ${response.code()}")
                }
//                onError("DCF")
            }
        })


    }

//    private val retrofit = Retrofit.Builder()
//            .baseUrl("https://switter.app.daftmobile.com/")
//            .build()
//
//    private val pokemonApi = retrofit.create(PokemonApi::class.java)
//
//    override fun fetch(index: String, onSuccess: (PokemonItem) -> Unit, onError: (String) -> Unit) {
//        val call = pokemonApi.getPokemonByIndex(index)
//        call.enqueue(object : Callback<ResponseBody> {
//            override fun onFailure(call: Call<ResponseBody>, t: Throwable) {
//                onError(t.message ?: "No message")
//            }
//
//            override fun onResponse(call: Call<ResponseBody>, response: Response<ResponseBody>) {
//                if (response.isSuccessful) {
//                    var a = response.body()?.string() ?: "Weird empty response"
//                    onSuccess(PokemonItem(a,"",101))
//                } else {
//                    onError("Serwer zwrócił: ${response.code()}")
//                }
//            }
//        })
//
//
//    }
}