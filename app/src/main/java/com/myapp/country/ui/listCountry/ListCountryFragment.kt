package com.myapp.country.ui.listCountry

import android.view.LayoutInflater
import com.myapp.country.base.BaseFragment
import com.myapp.country.databinding.ListCountryFragmentBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListCountryFragment : BaseFragment<ListCountryFragmentBinding, ListCountryViewModel>() {
    override val viewModel: ListCountryViewModel by viewModel()

    override fun inflateViewBinding(inflater: LayoutInflater) =
        ListCountryFragmentBinding.inflate(layoutInflater)

    override fun registerLiveData() {
        super.registerLiveData()
        viewModel.getListCountry()
    }
}
