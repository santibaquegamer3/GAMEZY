package com.example.gamezy

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.gamezy.databinding.ActivityNewsDetailBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NewsDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewsDetailBinding
    private lateinit var newsItem: Videojuego  // Ahora es Videojuego
    private var isFavorite = false
    private var isSaved = false
    private var isReadLater = false
    private lateinit var db: AppDatabase       // Base de datos

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Inicializar base de datos
        db = DatabaseInstance.getDatabase(this)

        // Obtener el videojuego del intent
        newsItem = if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            intent.getSerializableExtra("news_item", Videojuego::class.java) ?: getDefaultVideojuego()
        } else {
            @Suppress("DEPRECATION")
            intent.getSerializableExtra("news_item") as? Videojuego ?: getDefaultVideojuego()
        }

        // Inicializar estado de favoritos según la DB
        isFavorite = newsItem.isFavorite

        setupUI()
        setupClickListeners()
    }

    private fun getDefaultVideojuego(): Videojuego {
        return Videojuego(
            id = 1,
            nombre = "Slime Rancher",
            source = "10$",
            content = "Slime Rancher es una encantadora experiencia sandbox en primera persona...",
            publishTime = "Exploracion, Mundo Abierto y Gestion",
            category = "VideoGames",
            plataforma = "PC, Xbox y PlayStation",
            imageRes = R.drawable.slime_rancher_icon,
        )
    }

    private fun setupUI() {
        binding.tvTitle.text = newsItem.nombre
        binding.tvContent.text = if (newsItem.detailedContent.isNotEmpty()) {
            newsItem.detailedContent
        } else {
            newsItem.content
        }
        binding.tvSource.text = newsItem.source
        binding.tvPublishTime.text = newsItem.publishTime
        binding.tvCategory.text = newsItem.category

        updateButtonStates()
    }

    private fun setupClickListeners() {
        binding.btnBack.setOnClickListener { finish() }

        binding.btnFavorite.setOnClickListener { toggleFavorite() }

        binding.btnSave.setOnClickListener { toggleSave() }

        binding.btnReadLater.setOnClickListener { toggleReadLater() }
    }

    private fun toggleFavorite() {
        isFavorite = !isFavorite
        updateButtonStates()

        // Actualizamos en la base de datos
        lifecycleScope.launch(Dispatchers.IO) {
            newsItem.isFavorite = isFavorite
            db.videojuegoDao().actualizar(newsItem)
        }

        val message = if (isFavorite) "Agregado a Lista De Deseados" else "Removido de Lista De Deseados"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun toggleReadLater() {
        isReadLater = !isReadLater
        updateButtonStates()

        lifecycleScope.launch(Dispatchers.IO) {
            newsItem.isReadLater = isReadLater
            db.videojuegoDao().actualizar(newsItem)
        }

        val message = if (isReadLater) "Marcado para Leer Más Tarde" else "Removido de Leer Más Tarde"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    private fun toggleSave() {
        isSaved = !isSaved
        updateButtonStates()
        val message = if (isSaved) "Agregado Al Carrito" else "Removido Del Carrito"
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }



    private fun updateButtonStates() {
        // Botón de favorito
        if (isFavorite) {
            binding.ivFavoriteIcon.setColorFilter(getColor(R.color.background_card_two))
            binding.tvFavoriteText.text = "Añadido a Deseados"
            binding.btnFavorite.setCardBackgroundColor(getColor(R.color.accent_orange_dark))
            binding.tvFavoriteText.setTextColor(getColor(R.color.white_text))
        } else {
            binding.ivFavoriteIcon.setColorFilter(getColor(R.color.white))
            binding.tvFavoriteText.text = "Agregar a deseados"
            binding.btnFavorite.setCardBackgroundColor(getColor(R.color.accent_orange_light))
            binding.tvFavoriteText.setTextColor(getColor(R.color.text_secondary))
        }

        // Botón de guardar
        if (isSaved) {
            binding.ivSaveIcon.setColorFilter(getColor(R.color.background_card_two))
            binding.tvSaveText.text = "Añadido al Carrito"
            binding.btnSave.setCardBackgroundColor(getColor(R.color.primary_blue_dark))
            binding.tvSaveText.setTextColor(getColor(R.color.white_text))
        } else {
            binding.ivSaveIcon.setColorFilter(getColor(R.color.white))
            binding.tvSaveText.text = "Agregar a el Carrito"
            binding.btnSave.setCardBackgroundColor(getColor(R.color.primary_blue_light))
            binding.tvSaveText.setTextColor(getColor(R.color.text_secondary))
        }

        // Botón de leer más tarde
        if (isReadLater) {
            binding.ivReadLaterIcon.setColorFilter(getColor(R.color.background_card_two))
            binding.tvReadLaterText.text = "ME GUSTA"
            binding.btnReadLater.setCardBackgroundColor(getColor(R.color.primary_blue_dark))
            binding.tvReadLaterText.setTextColor(getColor(R.color.white_text))
        } else {
            binding.ivReadLaterIcon.setColorFilter(getColor(R.color.white))
            binding.tvReadLaterText.text = "me gusta"
            binding.btnReadLater.setCardBackgroundColor(getColor(R.color.success_green))
            binding.tvReadLaterText.setTextColor(getColor(R.color.text_secondary))
        }
    }
}