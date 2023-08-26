package com.z_ha.shopmonitor.model

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitSingleton {
    //replace the url (217.174.244.115) by the one used in the host server
    val baseUrl = "http://217.174.244.115:8080"
    fun getInstance(): Retrofit {
        return Retrofit.Builder().baseUrl(baseUrl)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }
}