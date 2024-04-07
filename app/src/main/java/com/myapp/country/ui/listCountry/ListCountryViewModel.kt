package com.myapp.country.ui.listCountry

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.myapp.country.base.BaseViewModel
import com.myapp.country.domain.entities.Country
import com.myapp.country.domain.usecase.GetListCountryUseCase
import com.myapp.country.utils.FieldType

class ListCountryViewModel(private val getListCountryUseCase: GetListCountryUseCase) :
    BaseViewModel() {

    private val _listCountry = MutableLiveData<List<Country>>()
    val listCountry: LiveData<List<Country>> get() = _listCountry

    fun getListCountry() = launchTaskAsync(
        onRequest = { getListCountryUseCase.call(FieldType.entries) },
        onSuccess = {
            Log.v("tag111", "data: $it")
            _listCountry.postValue(it)
        }
    )
}
