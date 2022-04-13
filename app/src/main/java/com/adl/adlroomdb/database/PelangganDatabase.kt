package com.adl.adlroomdb.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.adl.adlroomdb.database.dao.PelangganDAO
import com.adl.adlroomdb.database.model.EntPelanggan

@Database( version = 1,entities = [EntPelanggan::class])
abstract class PelangganDatabase:RoomDatabase() {
    abstract fun pelangganDao():PelangganDAO
}