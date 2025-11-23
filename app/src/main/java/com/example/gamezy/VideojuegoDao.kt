package com.example.gamezy

import androidx.room.*

@Dao
interface VideojuegoDao {

    @Insert
    suspend fun insertar(videojuego: Videojuego)

    @Update
    suspend fun actualizar(videojuego: Videojuego)

    @Delete
    suspend fun eliminar(videojuego: Videojuego)

    @Query("SELECT * FROM videojuegos ORDER BY nombre ASC")
    suspend fun obtenerTodos(): List<Videojuego>

    @Query("SELECT * FROM videojuegos WHERE id = :id LIMIT 1")
    suspend fun obtenerPorId(id: Int): Videojuego?

    @Query("SELECT * FROM videojuegos WHERE plataforma = :plataforma")
    suspend fun buscarPorPlataforma(plataforma: String): List<Videojuego>

    @Query("SELECT * FROM videojuegos WHERE id IN (:ids)")
    suspend fun obtenerPorIds(ids: List<Int>): List<Videojuego>

    @Query("SELECT * FROM videojuegos")
    suspend fun obtenerVideojuegos(): List<Videojuego>
    @Query("SELECT * FROM videojuegos WHERE isFavorite = 1")
    suspend fun obtenerFavoritos(): List<Videojuego>

    @Update
    suspend fun actualizarVideojuego(videojuego: Videojuego)


    @Query("SELECT * FROM videojuegos WHERE isReadLater = 1")
    suspend fun obtenerLeerMasTarde(): List<Videojuego>


}