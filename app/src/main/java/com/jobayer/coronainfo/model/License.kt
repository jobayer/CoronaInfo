package com.jobayer.coronainfo.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class License(val id: Int, val name: String) : Parcelable