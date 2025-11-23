package com.example.gamezy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamezy.databinding.FragmentFavoritesBinding
import kotlinx.coroutines.launch

class FavoritesFragment : Fragment() {

    private var _binding: FragmentFavoritesBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: VideojuegoAdapter
    private lateinit var db: AppDatabase

    private fun abrirDetalle(item: NewsItem) {
        val intent = Intent(requireContext(), NewsDetailActivity::class.java)
        intent.putExtra("news_item", item)
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentFavoritesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Inicializar RecyclerView
        binding.recyclerViewFavorites.layoutManager = LinearLayoutManager(requireContext())

        // Inicializar adapter con click listener
        adapter = VideojuegoAdapter { item ->
            val newsItem = NewsItem(
                id = item.id,
                title = item.nombre,
                content = item.content,                // Descripción completa
                source = item.source,                  // Precio
                publishTime = item.publishTime,        // Información extra
                category = item.category,              // Género
                imageRes = item.imageRes
            )
            abrirDetalle(newsItem)
        }

        binding.recyclerViewFavorites.adapter = adapter

        // Inicializar base de datos
        db = DatabaseInstance.getDatabase(requireContext())

        // Cargar los juegos favoritos
        cargarFavoritos()
    }

    private fun cargarFavoritos() {
        lifecycleScope.launch {
            // Solo los que estén marcados como favoritos
            val lista = db.videojuegoDao().obtenerFavoritos()
            adapter.submitList(lista)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}