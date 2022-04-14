package com.adl.adlroomdb.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Driver(
    @PrimaryKey val id_driver:Int,
    val nama:String,
    val umur:String,
    val alamat:String,
    val telepon:String
)
