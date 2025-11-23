package com.example.gamezy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.gamezy.databinding.FragmentReadLaterBinding
import kotlinx.coroutines.launch

class ReadLaterFragment : Fragment() {

    private var _binding: FragmentReadLaterBinding? = null
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
        _binding = FragmentReadLaterBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewReadLater.layoutManager = LinearLayoutManager(requireContext())

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
        binding.recyclerViewReadLater.adapter = adapter

        db = DatabaseInstance.getDatabase(requireContext())
        cargarLeerMasTarde() // Primera carga
    }

    override fun onResume() {
        super.onResume()
        cargarLeerMasTarde() // Recarga al volver a mostrar el fragmento
    }

    private fun cargarLeerMasTarde() {
        lifecycleScope.launch {
            val lista = db.videojuegoDao().obtenerLeerMasTarde()
            adapter.submitList(lista)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}