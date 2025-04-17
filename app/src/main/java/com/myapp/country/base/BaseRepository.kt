package com.myapp.country.base

import android.util.Log
import com.myapp.country.utils.DataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository {

    protected suspend fun <R> getResult(
        context: CoroutineContext = Dispatchers.IO,
        request: suspend CoroutineScope.() -> R
    ): DataResult<R> = withContext(context) {
        return@withContext try {
            val response = request()
            DataResult.Success(response)
        } catch (e: Exception) {
            Log.v("tag111", "exece[ption: $e")
            return@withContext DataResult.Error(e)
        }
    }
}
