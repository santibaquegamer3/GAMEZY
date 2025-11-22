package com.example.gamezy

import java.io.Serializable

data class NewsItem(
    val id: Int,
    val title: String,
    val content: String,
    val source: String,
    val detailedContent: String = "",
    val sourceLink: String = "",
    val publishTime: String,
    val category: String,
    val isFavorite: Boolean = false,
    val isSaved: Boolean = false,
    val isReadLater: Boolean = false,
    val imageRes : Int = 0,
) : Serializable
