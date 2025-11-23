package com.example.gamezy

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable

@Entity(tableName = "videojuegos")
data class Videojuego(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val nombre: String,
    val content: String,
    val source: String,
    val plataforma: String,
    val detailedContent: String = "",
    val sourceLink: String = "",
    val publishTime: String,
    val category: String,
    var isFavorite: Boolean = false,
    val isSaved: Boolean = false,
    var isReadLater: Boolean = false,
    val imageRes : Int = 0,
) : Serializable