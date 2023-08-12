package com.route.islamic38sat.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.route.islamic38sat.R
import com.route.islamic38sat.databinding.ActivityHomeBinding
import com.route.islamic38sat.ui.home.tabs.hadeth.HadethFragment
import com.route.islamic38sat.ui.home.tabs.quran.QuranFragment
import com.route.islamic38sat.ui.home.tabs.radio.RadioFragment
import com.route.islamic38sat.ui.home.tabs.tasbeh.TasbehFragment

class HomeActivity : AppCompatActivity() {
    lateinit var viewBinding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(viewBinding.root)

        viewBinding.content
            .bottomNav.setOnItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_quran -> {
                        showTabFragment(QuranFragment())
                    }

                    R.id.navigation_hadeth -> {
                        showTabFragment(HadethFragment())
                    }

                    R.id.navigation_radio -> {
                        showTabFragment(RadioFragment())
                    }

                    R.id.navigation_tasbeh -> {
                        showTabFragment(TasbehFragment())
                    }
                }
                true
            }

        viewBinding.content.bottomNav.selectedItemId = R.id.navigation_quran
    }

    private fun showTabFragment(fragment: Fragment) {
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}