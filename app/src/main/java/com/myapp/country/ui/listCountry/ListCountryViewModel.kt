package com.myapp.country.ui.listCountry

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.myapp.country.base.BaseViewModel
import com.myapp.country.domain.entities.Country
import com.myapp.country.domain.usecase.GetListCountryUseCase
import com.myapp.country.utils.FieldType
import kotlinx.coroutines.launch

class ListCountryViewModel(private val getListCountryUseCase: GetListCountryUseCase) :
    BaseViewModel() {

    private val _listCountry = MutableLiveData<List<Country>>()
    val listCountry: LiveData<List<Country>> get() = _listCountry

    private val _listCountryFilter = MutableLiveData<List<Country>>()
    val listCountryFilter: LiveData<List<Country>> get() = _listCountryFilter

    fun getListCountry() = launchTaskAsync(
        onRequest = { getListCountryUseCase.call(FieldType.entries) },
        onSuccess = {
            Log.v("tag111", "data: $it")
            _listCountry.postValue(it)
        }
    )

    fun filterByName(text: String) {
        viewModelScope.launch {
            val result =
                listCountry.value?.filter {
                    it.name.official?.contains(
                        text,
                        ignoreCase = true
                    ) == true
                }?.toList()
            _listCountryFilter.postValue(result ?: mutableListOf())
        }
    }

    fun clearFilter() {
        _listCountryFilter.value = listCountry.value?.toList() ?: mutableListOf()
    }
}
