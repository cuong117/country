package com.myapp.country.ui.listCountry

import android.util.Log
import com.myapp.country.base.BaseViewModel
import com.myapp.country.domain.usecase.GetListCountryUseCase
import com.myapp.country.utils.FieldType

class ListCountryViewModel(private val getListCountryUseCase: GetListCountryUseCase) :
    BaseViewModel() {

    fun getListCountry() = launchTaskAsync(
        onRequest = { getListCountryUseCase.call(FieldType.entries) },
        onSuccess = {
            Log.v("tag111", "data: $it")
        }
    )
}
