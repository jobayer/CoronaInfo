package com.jobayer.coronainfo.api

import com.jobayer.coronainfo.model.Districts
import com.jobayer.coronainfo.model.Stats
import retrofit2.Call
import retrofit2.http.GET

interface CoronaInfoAPI {

    @GET("stats")
    fun getStats(): Call<Stats>

    @GET("districts")
    fun getDistricts(): Call<Districts>

}