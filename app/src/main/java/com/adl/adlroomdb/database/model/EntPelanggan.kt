package com.adl.adlroomdb.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class EntPelanggan(
    @PrimaryKey(autoGenerate = true)  val idpelanggan:Int,
    val namapelanggan:String?,
    val alamat:String?,
    val telepon:String?,
    val email:String?
    )
