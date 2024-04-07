package com.myapp.country.ui

import android.os.Bundle
import android.view.LayoutInflater
import com.myapp.country.base.BaseActivity
import com.myapp.country.databinding.ActivityMainBinding
import com.myapp.country.ui.listCountry.ListCountryFragment
import com.myapp.country.utils.addFragment

class MainActivity: BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (savedInstanceState == null) {
            addFragment(
                fragment = ListCountryFragment.getInstance(),
                addToBackStack = false,
                container = viewBinding.container.id
            )
        }
    }
}
