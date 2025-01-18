package com.example.finance_app

import android.app.Application
import com.example.finance_app.data.repository.PositionsRepository

class App: Application() {
    val positionsRepositoryContainer by lazy { PositionsRepositoryContainer() }
}

class PositionsRepositoryContainer() {
    val positionsRepository: PositionsRepository by lazy { PositionsRepository() }
}