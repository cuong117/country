package com.myapp.country.ui.listCountry

import android.view.LayoutInflater
import android.view.Menu
import android.view.MenuInflater
import android.view.MenuItem
import android.widget.SearchView
import androidx.core.view.MenuProvider
import androidx.lifecycle.Lifecycle
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
    private val menuProvider = object : MenuProvider {
        override fun onCreateMenu(menu: Menu, menuInflater: MenuInflater) {
            menuInflater.inflate(R.menu.menu_search, menu)
            createMenu(menu)
        }

        override fun onMenuItemSelected(menuItem: MenuItem): Boolean {
            return true
        }
    }

    override fun inflateViewBinding(inflater: LayoutInflater) =
        ListCountryFragmentBinding.inflate(layoutInflater)

    override fun initView() {
        super.initView()
        viewBinding.listCountry.adapter = adapter
        adapter.setOnCountryClick(::onCountryClick)
        activity?.addMenuProvider(menuProvider, viewLifecycleOwner, Lifecycle.State.RESUMED)
    }

    override fun registerLiveData() {
        super.registerLiveData()
        viewModel.listCountry.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.listCountryFilter.observe(viewLifecycleOwner) {
            adapter.submitList(it)
        }
        viewModel.getListCountry()
    }

    private fun onCountryClick(country: Country) {
        (activity as? MainActivity)?.addFragment(
            fragment = CountryDetailFragment.getInstance(country),
            addToBackStack = true,
            container = R.id.container
        )
    }

    private fun createMenu(menu: Menu) {
        val searchItem = menu.findItem(R.id.search_bar)
        val searchView = searchItem.actionView as? SearchView
        searchView?.maxWidth = Int.MAX_VALUE
        searchView?.apply {
            setOnSearchClickListener {
                (activity as? MainActivity)?.supportActionBar?.setDisplayShowTitleEnabled(false)
            }

            setOnCloseListener {
                (activity as? MainActivity)?.supportActionBar?.setDisplayShowTitleEnabled(true)
                viewModel.clearFilter()
                return@setOnCloseListener false
            }

            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(text: String?): Boolean {
                    viewModel.filterByName(text ?: "")
                    searchView.clearFocus()
                    return false
                }

                override fun onQueryTextChange(p0: String?): Boolean {
                    return false
                }

            })
        }
    }

    companion object {
        fun getInstance() = ListCountryFragment()
    }
}
