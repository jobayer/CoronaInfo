package com.jobayer.coronainfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class District(
    val bnname: String,
    val confirmed: Int,
    val recovered: Int,
    val deaths: Int
) : Parcelable