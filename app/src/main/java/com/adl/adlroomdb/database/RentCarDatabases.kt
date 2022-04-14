package com.adl.adlroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.adl.adlroomdb.database.dao.PelangganDAO
import com.adl.adlroomdb.database.dao.RentCar
import com.adl.adlroomdb.database.model.*

@Database(entities = [Driver::class,Mobil::class], views =[JumlahMobilDriver::class], version = 2)
abstract class RentCarDatabases: RoomDatabase() {
    abstract fun daoRentCar():RentCar

    companion object{

        var instance:RentCarDatabases?=null

        @Synchronized
        fun getInstance(ctx: Context):RentCarDatabases{

            if(instance == null) {
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    RentCarDatabases::class.java,
                    "db_rent_car"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }


    }
}