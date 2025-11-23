package com.example.gamezy

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.coroutines.launch

class HomeFragment : Fragment() {

    private lateinit var adapter: VideojuegoAdapter
    private lateinit var recyclerViewHome: RecyclerView
    private lateinit var db: AppDatabase

    // 🔹 Función para abrir el detalle de un videojuego
    private fun abrirDetalle(item: Videojuego) {
        val intent = Intent(requireContext(), NewsDetailActivity::class.java)
        intent.putExtra("news_item", item) // Ahora pasamos directamente Videojuego
        startActivity(intent)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // 🔹 Inicializar RecyclerView
        recyclerViewHome = view.findViewById(R.id.recyclerViewHome)
        recyclerViewHome.layoutManager = LinearLayoutManager(requireContext())

        // 🔹 Inicializar adapter
        adapter = VideojuegoAdapter { item ->
            abrirDetalle(item) // Ahora abrimos directamente el Videojuego
        }

        recyclerViewHome.adapter = adapter

        // 🔹 Inicializar base de datos
        db = DatabaseInstance.getDatabase(requireContext())

        // 🔹 Cargar datos
        cargarArticulos()
    }

    private fun cargarArticulos() {
        val idsQueQuiero = listOf(1, 3, 5, 7, 8, 11) // Cambia los IDs según necesites

        lifecycleScope.launch {
            val lista = db.videojuegoDao().obtenerPorIds(idsQueQuiero)
            adapter.submitList(lista)
        }
    }
}

