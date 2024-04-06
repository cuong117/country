package com.myapp.country.utils

import java.lang.Exception

sealed class DataResult<R> {
    data class Success<T>(val data: T): DataResult<T>()
    data class Error(val exception: Exception): DataResult<Exception>()
}
