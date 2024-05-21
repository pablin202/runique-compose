package com.pdm.runique.auth.data

import com.pdm.runique.auth.domain.AuthRepository
import com.pdm.runique.core.data.networking.post
import com.pdm.runique.core.domain.util.DataError
import com.pdm.runique.core.domain.util.EmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient
) : AuthRepository {
    override suspend fun register(
        email: String,
        password: String
    ): EmptyDataResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email,
                password
            )
        )
    }
}