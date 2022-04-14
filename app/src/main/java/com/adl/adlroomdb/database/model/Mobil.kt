package com.adl.adlroomdb.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Mobil(
    @PrimaryKey val id_mesin:Int,
    val nama:String,
    val cc:String,
    val tipe:String,
    val id_driver:Int
    )
