package com.myapp.country.ui.countryDetail.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import com.myapp.country.base.BaseAdapter
import com.myapp.country.base.BaseViewHolder
import com.myapp.country.databinding.CountryNameItemBinding
import com.myapp.country.domain.entities.Name

class CountryNameAdapter :
    BaseAdapter<Pair<String, Name>, CountryNameItemBinding, CountryNameAdapter.CountryNameViewHolder>(
        diffCallback = diffCallBack
    ) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryNameViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val viewBinding = CountryNameItemBinding.inflate(layoutInflater, parent, false)
        return CountryNameViewHolder(viewBinding)
    }

    class CountryNameViewHolder(private val viewBinding: CountryNameItemBinding) :
        BaseViewHolder<Pair<String, Name>, CountryNameItemBinding>(viewBinding) {

        override fun onBindData(data: Pair<String, Name>) {
            super.onBindData(data)
            viewBinding.languageCode.text = data.first
            viewBinding.officialName.text = data.second.official
            viewBinding.commonName.text = data.second.common
        }
    }

    companion object {
        private val diffCallBack = object : DiffUtil.ItemCallback<Pair<String, Name>>() {
            override fun areItemsTheSame(
                oldItem: Pair<String, Name>,
                newItem: Pair<String, Name>
            ): Boolean {
                return oldItem.first == newItem.first
            }

            override fun areContentsTheSame(
                oldItem: Pair<String, Name>,
                newItem: Pair<String, Name>
            ): Boolean {
                return oldItem.first == newItem.first && oldItem.second == newItem.second
            }
        }
    }
}
