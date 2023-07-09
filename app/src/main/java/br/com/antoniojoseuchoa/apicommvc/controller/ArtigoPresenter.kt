package br.com.antoniojoseuchoa.apicommvc.controller

import android.util.Log
import br.com.antoniojoseuchoa.apicommvc.model.Artigo
import br.com.antoniojoseuchoa.apicommvc.model.api.RetrofitService
import br.com.antoniojoseuchoa.apicommvc.view.MainActivity
import kotlinx.coroutines.*
import retrofit2.Response

class ArtigoPresenter(val activity: MainActivity) {

    private val retrofit = RetrofitService.retrofit

    val coroutine =  CoroutineScope(Dispatchers.IO)

    fun recuperarArtigos(){
          var retorno: Response<List<Artigo>>? = null
          coroutine.launch {
             try{
                retorno = retrofit.getArtigos()
                withContext(Dispatchers.Main){
                    if(retorno != null){
                        val list = retorno?.body()
                        list?.let {
                            activity.exibirArtigos(it)
                        }
                    }
                }
             }catch (ex: Exception) {
                 Log.i("erro", "recuperarArtigos: ${ex.message}")
             }
          }
    }

    fun onDestroy(){
        coroutine.cancel()
    }

}