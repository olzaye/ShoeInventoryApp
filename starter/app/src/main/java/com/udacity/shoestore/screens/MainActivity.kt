package com.udacity.shoestore.screens

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.udacity.shoestore.R
import com.udacity.shoestore.databinding.ActivityMainBinding
import com.udacity.shoestore.screens.showList.ActivityViewModel

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: ActivityViewModel
    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var navHostFragment: NavHostFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(
            this,
            R.layout.activity_main
        )
        viewModel = ViewModelProvider(this).get(ActivityViewModel::class.java)
        setSupportActionBar(binding.toolbar)
        navHostFragment =
            supportFragmentManager.findFragmentById(R.id.loginNavHostFragment) as NavHostFragment

        appBarConfiguration = AppBarConfiguration(navHostFragment.navController.graph)
        NavigationUI.setupActionBarWithNavController(
            this,
            navHostFragment.navController,
            appBarConfiguration
        )
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(
            navHostFragment.navController,
            appBarConfiguration
        )
    }

    fun showBackButtonArrow(shouldShow: Boolean) {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        supportActionBar?.setHomeButtonEnabled(false)
    }
}
