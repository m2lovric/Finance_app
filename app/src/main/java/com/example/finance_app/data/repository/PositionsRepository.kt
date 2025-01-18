package com.example.finance_app.data.repository

import com.example.finance_app.data.models.Position
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class PositionsRepository {
    private val _positions = MutableStateFlow<List<Position>>(emptyList())
    private val positions: StateFlow<List<Position>> = _positions

    private var id = 0
    fun getPositions(): StateFlow<List<Position>> {
        return positions
    }

    fun addPositions(
        tickerSymbol: String,
        quantity: Double,
        purchasePrice: Double,
        purchaseDate: LocalDate
    ) {
        _positions.value += Position(id = id++, tickerSymbol, quantity, purchasePrice, purchaseDate)
    }
}