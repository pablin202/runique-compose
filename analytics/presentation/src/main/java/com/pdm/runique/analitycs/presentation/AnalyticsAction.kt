package com.pdm.runique.analitycs.presentation

sealed interface AnalyticsAction {
    data object OnBackClick: AnalyticsAction
}