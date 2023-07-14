package br.com.antoniojoseuchoa.apicommvc.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    companion object{
        const val BASE_URL = "https://antoniojose2023.github.io/apiartigos/"

        val retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ArtigosApi::class.java)
    }
}