package com.pdm.runique.auth.domain

import com.pdm.runique.core.domain.util.DataError
import com.pdm.runique.core.domain.util.EmptyResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyResult<DataError.Network>
    suspend fun login(email: String, password: String): EmptyResult<DataError.Network>
}