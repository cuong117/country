package com.myapp.country

import android.view.LayoutInflater
import com.myapp.country.base.BaseActivity
import com.myapp.country.databinding.ActivityMainBinding

class MainActivity: BaseActivity<ActivityMainBinding>() {
    override fun inflateViewBinding(inflater: LayoutInflater) =
        ActivityMainBinding.inflate(inflater)
}
