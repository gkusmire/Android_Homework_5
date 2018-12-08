package com.daftmobile.a4bhomework5

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonApi {

    @GET("/api/pokemon/{index}/peek")
    fun getPokemonByIndex(@Path("index") index:String): Call<PokemonItem>

}