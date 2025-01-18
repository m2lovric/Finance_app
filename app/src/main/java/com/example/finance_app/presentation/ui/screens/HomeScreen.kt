package com.example.finance_app.presentation.ui.screens

import android.icu.text.NumberFormat
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Card
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.finance_app.presentation.viewmodels.PositionsViewModel
import com.example.finance_app.presentation.viewmodels.PositionsViewModel.Companion.factory
import java.util.Locale

@Composable
fun HomeScreen(modifier: Modifier = Modifier) {
    val positionsViewModel: PositionsViewModel = viewModel(factory = PositionsViewModel.factory)
    Scaffold() { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
        ) {
            TotalBalance()
            PositionsListScreen(positionsViewModel, Modifier)
        }
    }
}

@Composable
fun TotalBalance(modifier: Modifier = Modifier) {
    val totalBalance = 12300
    val formatted = NumberFormat.getCurrencyInstance(Locale.GERMANY).format(totalBalance)
    Card(
        modifier = Modifier
            .size(width = 240.dp, height = 100.dp)
    ) {
        Text(
            text = "Total balance",
            textAlign = TextAlign.Left,
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = formatted,
            fontSize = 28.sp,
            modifier = Modifier
                .padding(start = 16.dp)
        )
    }
}

@Composable
@Preview
fun HomeScreenPreview(modifier: Modifier = Modifier.fillMaxSize()) {
    HomeScreen()
}