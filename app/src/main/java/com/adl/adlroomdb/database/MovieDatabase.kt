package com.adl.adlroomdb.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.adl.adlroomdb.database.dao.MovieDao
import com.adl.adlroomdb.database.model.EntPelanggan
import com.adl.adlroomdb.database.model.MovieModel

@Database( version = 1,entities = [MovieModel::class])
abstract  class MovieDatabase:RoomDatabase() {

    abstract  fun movieDao():MovieDao

    companion object{

        var instance:MovieDatabase?=null

        @Synchronized
        fun getInstance(ctx: Context):MovieDatabase{

            if(instance == null) {
                instance = Room.databaseBuilder(
                    ctx.applicationContext,
                    MovieDatabase::class.java,
                    "db_movie"
                )
                    .fallbackToDestructiveMigration()
                    .build()
            }

            return instance!!
        }


    }
//
//    private val movieCallback = object:Callback(){
//        override fun onCreate(db: SupportSQLiteDatabase) {
//            super.onCreate(db)
//            popu
//        }
//    }

}