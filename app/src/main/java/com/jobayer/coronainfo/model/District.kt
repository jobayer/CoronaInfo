package com.jobayer.coronainfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class District(
    val name: String,
    val bnname: String,
    val tested: Int,
    val confirmed: Int,
    val recovered: Int,
    val deaths: Int
) : Parcelable