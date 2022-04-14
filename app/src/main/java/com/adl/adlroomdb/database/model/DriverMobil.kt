package com.adl.adlroomdb.database.model

import androidx.room.Embedded
import androidx.room.Entity
import androidx.room.Relation


data class DriverMobil(
    @Embedded val driver:Driver,
    @Relation(
         parentColumn = "id_driver",
         entityColumn = "id_driver"
    )
    val mobil: List<Mobil>
)
