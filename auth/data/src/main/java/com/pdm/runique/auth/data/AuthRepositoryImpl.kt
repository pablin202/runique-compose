package com.pdm.runique.auth.data

import com.pdm.runique.auth.domain.AuthRepository
import com.pdm.runique.core.data.networking.post
import com.pdm.runique.core.domain.AuthInfo
import com.pdm.runique.core.domain.SessionStorage
import com.pdm.runique.core.domain.util.DataError
import com.pdm.runique.core.domain.util.EmptyResult
import com.pdm.runique.core.domain.util.Result
import com.pdm.runique.core.domain.util.asEmptyDataResult
import io.ktor.client.HttpClient

class AuthRepositoryImpl(
    private val httpClient: HttpClient,
    private val sessionStorage: SessionStorage
) : AuthRepository {
    override suspend fun register(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        return httpClient.post<RegisterRequest, Unit>(
            route = "/register",
            body = RegisterRequest(
                email,
                password
            )
        )
    }

    override suspend fun login(
        email: String,
        password: String
    ): EmptyResult<DataError.Network> {
        val result = httpClient.post<LoginRequest, LoginResponse>(
            route = "/login",
            body = LoginRequest(
                email,
                password
            )
        )

        if(result is Result.Success) {
            sessionStorage.set(
                AuthInfo(
                    accessToken = result.data.accessToken,
                    refreshToken = result.data.refreshToken,
                    userId = result.data.userId
                )
            )
        }
        return result.asEmptyDataResult()
    }
}