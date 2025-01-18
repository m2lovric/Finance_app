package com.example.finance_app.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finance_app.presentation.viewmodels.PositionsViewModel

@Composable
fun PositionsListScreen(viewModel: PositionsViewModel, modifier: Modifier) {
    val positions by viewModel.positions.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        Text(
            text = "Positions",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )
        LazyColumn {
            items(positions) { position ->
                Row {
                    Text(text = "Ticker: ${position.tickerSymbol}")
                    Text(text = "Quantity: ${position.quantity}")
                    Text(text = "Purchase Price: ${position.purchasePrice}")
                    Text(text = position.purchaseDate.toString())
                }
            }
        }
    }
}