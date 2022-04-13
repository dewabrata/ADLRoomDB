package com.adl.adlroomdb.database.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class MovieModel(val title:String, val release:String,
                      val director:String, val actor:String,
                      val rating:String, val photo:String) :Parcelable
