package com.myapp.country.domain.usecase

interface UseCase<R, P> {
    suspend fun call(params: P): R
}
