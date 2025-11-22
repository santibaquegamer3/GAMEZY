package com.example.gamezy

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.gamezy.databinding.ItemArticleBinding

class NewsAdapter(private val articles: List<NewsItem>) :
    RecyclerView.Adapter<NewsAdapter.ArticleViewHolder>() {

    inner class ArticleViewHolder(val binding: ItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ArticleViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ArticleViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ArticleViewHolder, position: Int) {
        val article = articles[position]
        
        holder.binding.articleTitle.text = article.title
        holder.binding.articleSource.text = article.source
        holder.binding.imageView.setImageResource(article.imageRes)

        // Configurar click listener
        holder.itemView.setOnClickListener {
            val intent = Intent(holder.itemView.context, NewsDetailActivity::class.java)
            intent.putExtra("news_item", article)
            holder.itemView.context.startActivity(intent)
        }
    }

    override fun getItemCount() = articles.size
}
