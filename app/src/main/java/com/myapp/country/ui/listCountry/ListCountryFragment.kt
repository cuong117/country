package com.myapp.country.ui.listCountry

import android.util.Log
import android.view.LayoutInflater
import com.myapp.country.R
import com.myapp.country.base.BaseFragment
import com.myapp.country.databinding.ListCountryFragmentBinding
import com.myapp.country.domain.entities.Country
import com.myapp.country.ui.MainActivity
import com.myapp.country.ui.countryDetail.CountryDetailFragment
import com.myapp.country.ui.listCountry.adapter.ListCountryAdapter
import com.myapp.country.utils.addFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class ListCountryFragment : BaseFragment<ListCountryFragmentBinding, ListCountryViewModel>() {
    override val viewModel: ListCountryViewModel by viewModel()
    private val adapter by lazy { ListCountryAdapter() }

    override fun inflateViewBinding(inflater: LayoutInflater) =
        ListCountryFragmentBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        viewBinding.listCountry.adapter = adapter
        adapter.setOnCountryClick(::onCountryClick)
    }
    override fun registerLiveData() {
        super.registerLiveData()
        viewModel.listCountry.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.getListCountry()
    }

    private fun onCountryClick(country: Country) {
        Log.v("tag111", "onClick")
        (activity as? MainActivity)?.addFragment(
            fragment = CountryDetailFragment.getInstance(country),
            addToBackStack = true,
            container = R.id.container
        )
    }

    companion object {
        fun getInstance() = ListCountryFragment()
    }
}
