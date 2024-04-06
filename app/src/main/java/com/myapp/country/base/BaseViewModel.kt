package com.myapp.country.base

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.myapp.country.utils.DataResult
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    protected fun <T> launchTaskAsync(
        onRequest: suspend CoroutineScope.() -> DataResult<T>,
        onSuccess: (T) -> Unit,
        onError: ((Exception) -> Unit)? = null
    ) {
        viewModelScope.launch {
            when (val result = onRequest()) {
                is DataResult.Success -> onSuccess(result.data)
                is DataResult.Error -> onError?.invoke(result.exception)
            }
        }
    }
}
