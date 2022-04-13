package com.adl.adlroomdb.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.adl.adlroomdb.database.model.EntPelanggan
import com.adl.adlroomdb.database.model.MovieModel

@Dao
interface MovieDao {

    @Insert
    fun insertMovie(movie: MovieModel)

    @Delete
    fun deleteModel(movie: MovieModel)

    @Query("SELECT * FROM MovieModel")
    fun getAll(): List<MovieModel>
}