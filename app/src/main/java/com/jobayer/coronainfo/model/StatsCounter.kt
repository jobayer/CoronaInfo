package com.jobayer.coronainfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class StatsCounter(
    val confirmed: Int,
    val deaths: Int,
    val recovered: Int,
    val tested: Int
) : Parcelable