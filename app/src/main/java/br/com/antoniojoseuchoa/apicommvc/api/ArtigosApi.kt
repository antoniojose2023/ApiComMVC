package br.com.antoniojoseuchoa.apicommvc.api

import br.com.antoniojoseuchoa.apicommvc.model.Artigo
import retrofit2.Response
import retrofit2.http.GET

interface ArtigosApi {
    @GET("artigos.json")
    suspend fun getArtigos(): Response<List<Artigo>>
}