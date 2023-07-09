package br.com.antoniojoseuchoa.apicommvc.model

import com.google.gson.annotations.SerializedName

data class Artigo(
    @SerializedName("data")
    val dataPublicacao : String,
    val description: String,
    //val id: Int,
    val title: String,
    val url_imagem: String
)