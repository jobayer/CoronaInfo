package com.jobayer.coronainfo

import android.app.Application
import io.paperdb.Paper

class CoronaInfo: Application() {

    override fun onCreate() {
        super.onCreate()
        Paper.init(this)
    }

}