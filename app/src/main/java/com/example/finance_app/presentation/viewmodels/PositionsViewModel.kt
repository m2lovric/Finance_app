package com.example.finance_app.presentation.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.finance_app.App
import com.example.finance_app.data.models.Position
import com.example.finance_app.data.repository.PositionsRepository
import kotlinx.coroutines.flow.StateFlow
import java.time.LocalDate

class PositionsViewModel(private val repository: PositionsRepository): ViewModel() {
    val positions: StateFlow<List<Position>> = repository.getPositions()

    fun addPosition(tickerSymbol: String, quantity: Double, purchasePrice: Double, purchaseDate: LocalDate) {
        if(tickerSymbol.isNotBlank() && quantity > 0 && purchasePrice > 0) {
            repository.addPositions(tickerSymbol, quantity, purchasePrice, purchaseDate)
        }
    }

    companion object {
        val factory = viewModelFactory {
            initializer {
                val app = this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as App
                val repository = app.positionsRepositoryContainer.positionsRepository
                PositionsViewModel(repository)
            }
        }
    }
}