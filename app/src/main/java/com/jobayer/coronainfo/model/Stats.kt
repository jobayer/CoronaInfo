package com.jobayer.coronainfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Stats(
    val last: StatsCounter,
    val lastUpdate: String,
    val total: StatsCounter
) : Parcelable