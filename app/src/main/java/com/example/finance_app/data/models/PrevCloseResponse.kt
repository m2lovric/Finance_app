package com.example.finance_app.data.models

data class PrevCloseResponse(
    val status: String,
    val ticker: String,
    val results: List<StockResult>
)

data class StockResult(
    val c: Double,
    val h: Double,
    val l: Double,
    val o: Double,
    val t: Long,
    val v: Long,
    val vw: Double
)