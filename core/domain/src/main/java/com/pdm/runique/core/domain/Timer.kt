package com.pdm.runique.core.domain

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlin.time.Duration
import kotlin.time.Duration.Companion.microseconds

object Timer {
    fun timeAndEmit() : Flow<Duration> {
        var lastEmitTime = System.currentTimeMillis()
        return flow {
            while (true) {
                delay(200L)
                val currentTime = System.currentTimeMillis()
                val elapsedTime = currentTime - lastEmitTime
                emit(elapsedTime.microseconds)
                lastEmitTime = currentTime
            }
        }
    }
}