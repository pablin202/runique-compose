package com.pdm.runique.analitycs.domain

interface AnalyticsRepository {
    suspend fun getAnalyticsValues(): AnalyticsValues
}