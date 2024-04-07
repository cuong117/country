package com.myapp.country.utils

import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.myapp.country.R

fun AppCompatActivity.addFragment(
    fragment: Fragment,
    addToBackStack: Boolean,
    container: Int,
    tag: String? = null
) {
    supportFragmentManager.beginTransaction().apply {
        setCustomAnimations(
            R.anim.bottom_to_top,
            R.anim.bottom_to_top,
            R.anim.top_to_bottom,
            R.anim.top_to_bottom
        )
        add(container, fragment, tag)
        if (addToBackStack) {
            addToBackStack(null)
        }
        commit()
    }
}
