package com.adl.resepfragment.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class ResepModel(val title:String, val keterangan:String,val image:String) :Parcelable
