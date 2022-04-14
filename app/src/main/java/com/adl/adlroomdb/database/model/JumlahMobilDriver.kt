package com.adl.adlroomdb.database.model

import androidx.room.ColumnInfo
import androidx.room.DatabaseView
import androidx.room.Ignore


@DatabaseView(
    "select driver.nama, driver.alamat,(SELECT count(*)  from Mobil where Mobil.id_driver = driver.id_driver)  as jml_mobil\n" +
            "FROM Driver "
)

data class JumlahMobilDriver(
    var nama:String,
    var alamat:String,

    var jml_mobil:Int =0)