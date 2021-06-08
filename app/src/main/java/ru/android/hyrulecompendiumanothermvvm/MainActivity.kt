package ru.android.hyrulecompendiumanothermvvm

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import ru.android.hyrulecompendiumanothermvvm.presentation.MainActivityContract
import ru.android.hyrulecompendiumanothermvvm.presentation.home.HomeFragmentDirections

class MainActivity : AppCompatActivity(), MainActivityContract {

    private val navHostFragmentId = R.id.main_nav_host_fragment
    private val navController by lazy { findNavController(navHostFragmentId) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun openCategoryScreen(category: String) {
        navController.navigate(
            HomeFragmentDirections.actionHomeFragmentToHyruleFragment(category = category)
        )
    }

}