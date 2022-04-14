package com.adl.adlroomdb.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Transaction
import com.adl.adlroomdb.database.model.Driver
import com.adl.adlroomdb.database.model.DriverMobil
import com.adl.adlroomdb.database.model.Mobil

@Dao
interface RentCar {

    @Insert
    fun insertMobil(mobil: Mobil)

    @Insert
    fun insertDriver(driver:Driver)

    @Transaction
    @Query("select * from Driver")
    fun getDriverMobil():List<DriverMobil>


}