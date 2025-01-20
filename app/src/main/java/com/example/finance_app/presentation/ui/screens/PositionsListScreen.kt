package com.example.finance_app.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.example.finance_app.data.api.ApiClient
import com.example.finance_app.data.models.PrevCloseResponse
import com.example.finance_app.presentation.viewmodels.PositionsViewModel

@Composable
fun PositionsListScreen(viewModel: PositionsViewModel, modifier: Modifier) {
    val positions by viewModel.positions.collectAsState()
    val apiClient = remember { ApiClient.api }
    var stockInfo by remember { mutableStateOf<PrevCloseResponse?>(null) }

    LaunchedEffect("AAPL") {
        try {
            val response = apiClient.getPrevClose("AAPL")
            if (response.isSuccessful) {
                stockInfo = response.body()
            } else {

            }
        } catch (e: Exception) {

        }
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp)
    ) {
        if (stockInfo != null) {
            Text(text = "${stockInfo?.ticker}")
        }
        Text(
            text = "Positions",
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(start = 16.dp, top = 24.dp)
        )
        LazyColumn {
            items(positions) { position ->
                Box(modifier = Modifier.padding(8.dp)){
                    Column {
                        Text(text = "Ticker: ${position.tickerSymbol}")
                        Text(text = "Quantity: ${position.quantity}")
                        Text(text = "Purchase Price: ${position.purchasePrice}")
                        Text(text = position.purchaseDate.toString())
                        Text(text = "Value: ${position.purchasePrice * position.quantity}")
                    }
                }
            }
        }
    }
}