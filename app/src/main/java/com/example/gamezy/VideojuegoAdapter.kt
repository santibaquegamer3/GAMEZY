package com.example.gamezy

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView

class VideojuegoAdapter(
    private val onItemClick: (Videojuego) -> Unit = {}
) : ListAdapter<Videojuego, VideojuegoAdapter.VideojuegoViewHolder>(DiffCallback) {

    object DiffCallback : DiffUtil.ItemCallback<Videojuego>() {
        override fun areItemsTheSame(oldItem: Videojuego, newItem: Videojuego): Boolean =
            oldItem.id == newItem.id

        override fun areContentsTheSame(oldItem: Videojuego, newItem: Videojuego): Boolean =
            oldItem == newItem
    }

    inner class VideojuegoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val imgJuego: ImageView = itemView.findViewById(R.id.imageView)
        private val txtNombre: TextView = itemView.findViewById(R.id.articleTitle)
        private val txtFuente: TextView = itemView.findViewById(R.id.articleSource)

        fun bind(item: Videojuego) {
            txtNombre.text = item.nombre
            txtFuente.text = item.source

            if (item.imageRes != 0) {
                imgJuego.setImageResource(item.imageRes)
            }

            itemView.setOnClickListener { onItemClick(item) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VideojuegoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_article, parent, false)
        return VideojuegoViewHolder(view)
    }

    override fun onBindViewHolder(holder: VideojuegoViewHolder, position: Int) {
        holder.bind(getItem(position))
    }
}
