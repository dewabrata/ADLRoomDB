package com.adl.adlroomdb.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.adl.adlroomdb.database.model.EntPelanggan

@Dao
interface PelangganDAO {
    @Insert
    fun insertAll(pelanggan: EntPelanggan)

    @Delete
    fun delete(pelanggan: EntPelanggan)

    @Query("SELECT * FROM EntPelanggan")
    fun getAll(): List<EntPelanggan>

    @Query("Delete from EntPelanggan ")
    fun deleteAll()

}