package com.myapp.country.ui.countryDetail

import android.os.Build
import android.view.LayoutInflater
import androidx.core.os.bundleOf
import com.myapp.country.base.BaseFragment
import com.myapp.country.base.EmptyViewModel
import com.myapp.country.databinding.CountryDetailFragmentBinding
import com.myapp.country.domain.entities.Country
import com.myapp.country.ui.MainActivity
import com.myapp.country.ui.countryDetail.adapter.CountryNameAdapter
import com.myapp.country.utils.showImage
import org.koin.androidx.viewmodel.ext.android.viewModel

class CountryDetailFragment : BaseFragment<CountryDetailFragmentBinding, EmptyViewModel>() {
    override val viewModel: EmptyViewModel by viewModel()
    private val adapter by lazy { CountryNameAdapter() }
    private val country by lazy {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            arguments?.getParcelable(COUNTRY_KEY, Country::class.java)
        } else {
            arguments?.getParcelable(COUNTRY_KEY)
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater) =
        CountryDetailFragmentBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        viewBinding.run {
            countryImage.showImage(
                url = country?.flags?.imageSVG ?: "",
                alternativeUrl = country?.flags?.imagePNG ?: ""
            )
            officialName.text = country?.name?.official
            commonName.text = country?.name?.common
            listOtherName.adapter = adapter
            adapter.submitList(country?.name?.nativeName?.toList())
            backImage.setOnClickListener {
                activity?.supportFragmentManager?.popBackStack()
            }
        }
        (activity as? MainActivity)?.supportActionBar?.hide()
    }

    override fun onDestroy() {
        super.onDestroy()
        (activity as? MainActivity)?.supportActionBar?.show()
    }

    companion object {
        private const val COUNTRY_KEY = "COUNTRY_KEY"
        fun getInstance(country: Country): CountryDetailFragment = CountryDetailFragment().apply {
            arguments = bundleOf(
                COUNTRY_KEY to country
            )
        }
    }
}
