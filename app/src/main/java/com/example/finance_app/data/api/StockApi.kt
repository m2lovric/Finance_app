package com.example.finance_app.data.api

import com.example.finance_app.data.models.PrevCloseResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StockApi {
    @GET("v2/aggs/ticker/{ticker}/prev?adjusted=true")
    suspend fun getPrevClose(
        @Path("ticker") ticker: String
    ): Response<PrevCloseResponse>
}