package com.z_ha.shopmonitor

import com.z_ha.shopmonitor.model.Tick
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface TickApi {
    @POST("/dispatch")
    suspend fun sendTick(@Query("info") info: String)
    @GET("/status")
    suspend fun getLastTick() : Tick

}