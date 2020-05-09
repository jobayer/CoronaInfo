package com.jobayer.coronainfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
class Districts(
    val data: ArrayList<District>,
    val lastUpdate: String
) : Parcelable