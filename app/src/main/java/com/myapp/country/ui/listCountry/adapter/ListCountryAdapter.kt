package com.myapp.country.ui.listCountry.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.myapp.country.base.BaseAdapter
import com.myapp.country.base.BaseViewHolder
import com.myapp.country.databinding.CountryItemBinding
import com.myapp.country.domain.entities.Country
import com.myapp.country.utils.showImage

class ListCountryAdapter :
    BaseAdapter<Country, CountryItemBinding, ListCountryAdapter.ListCountryViewHolder>(
        diffCallback = diffCallback
    ) {

    private var onCountryClick: (Country) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListCountryViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = CountryItemBinding.inflate(layoutInflater, parent, false)
        return ListCountryViewHolder(viewBinding, onCountryClick)
    }

    fun setOnCountryClick(onCountryClick: (Country) -> Unit = {}) {
        this.onCountryClick = onCountryClick
    }

    class ListCountryViewHolder(
        private val viewBinding: CountryItemBinding,
        private val onCountryClick: (Country) -> Unit
    ) :
        BaseViewHolder<Country, CountryItemBinding>(viewBinding) {

        init {
            viewBinding.content.setOnClickListener {
                Log.v("tag111", "click $data")
                data?.let(onCountryClick)
            }
        }

        override fun onBindData(data: Country) {
            super.onBindData(data)
            viewBinding.countryImage.showImage(
                url = data.flags?.imageSVG ?: "",
                alternativeUrl = data.flags?.imagePNG ?: ""
            )
            viewBinding.countryNameTextView.text = data.name?.official
        }
    }

    companion object {
        private val diffCallback = object : DiffUtil.ItemCallback<Country>() {
            override fun areItemsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem.name?.official == newItem.name?.official
            }

            override fun areContentsTheSame(oldItem: Country, newItem: Country): Boolean {
                return oldItem == newItem
            }
        }
    }
}
