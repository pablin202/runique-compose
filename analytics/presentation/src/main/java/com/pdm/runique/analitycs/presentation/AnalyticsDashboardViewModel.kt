package com.pdm.runique.analitycs.presentation

import androidx.lifecycle.ViewModel
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue

class AnalyticsDashboardViewModel : ViewModel() {
    var state by mutableStateOf<AnalyticsDashboardState?>(null)
        private set
}