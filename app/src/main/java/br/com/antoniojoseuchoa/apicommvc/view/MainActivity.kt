package br.com.antoniojoseuchoa.apicommvc.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import br.com.antoniojoseuchoa.apicommvc.controller.ArtigoPresenter
import br.com.antoniojoseuchoa.apicommvc.databinding.ActivityMainBinding
import br.com.antoniojoseuchoa.apicommvc.model.Artigo

class MainActivity : AppCompatActivity() {
    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private lateinit var artigoPresenter: ArtigoPresenter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

         artigoPresenter = ArtigoPresenter(this)
         binding.btRecuperarArtigos.setOnClickListener {
             artigoPresenter.recuperarArtigos()
         }
    }

    override fun onStart() {
       super.onStart()
    }

    fun exibirArtigos(list: List<Artigo>){
        var resultado = ""

        list.forEach { artigo ->
            resultado += "${artigo.title} \n ${artigo.description} \n\n"
        }

        binding.tvResultado.text = resultado
    }
}