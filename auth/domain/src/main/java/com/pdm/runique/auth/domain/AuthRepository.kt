package com.pdm.runique.auth.domain

import com.pdm.runique.core.domain.util.DataError
import com.pdm.runique.core.domain.util.EmptyDataResult

interface AuthRepository {
    suspend fun register(email: String, password: String): EmptyDataResult<DataError.Network>
}