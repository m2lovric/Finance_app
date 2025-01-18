package com.example.finance_app.data.models

import java.time.LocalDate

data class Position (
    val id: Int,
    val tickerSymbol: String,
    val quantity: Double,
    val purchasePrice: Double,
    val purchaseDate: LocalDate
)