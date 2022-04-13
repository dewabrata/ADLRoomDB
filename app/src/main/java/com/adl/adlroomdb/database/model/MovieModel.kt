package com.adl.adlroomdb.database.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Parcelize
@Entity
data class MovieModel(@PrimaryKey(autoGenerate = true) val id:Long = 0,
                      val title:String, val release:String,
                      val director:String, val actor:String,
                      val rating:String, val photo:String) :Parcelable
