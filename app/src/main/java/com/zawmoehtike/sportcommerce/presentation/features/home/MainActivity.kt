package com.zawmoehtike.sportcommerce.presentation.features.home

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.zawmoehtike.sportcommerce.R
import com.zawmoehtike.sportcommerce.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var currentDesID: Int? = null

    val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
    }

    private val navController by lazy {
        navHostFragment.navController
    }

    private val navCtrlDesChangeListener = NavController.OnDestinationChangedListener { _, destination, _ ->
        currentDesID = destination.id

        if(destination.id == R.id.fragmentHome ||
            destination.id == R.id.fragmentSaved ||
            destination.id == R.id.fragmentCart ||
            destination.id == R.id.fragmentSearch) {

            changeActiveBottomNavBarIcon(destination.id)

            binding.layoutBottomNav.visibility = View.VISIBLE
        } else {
            binding.layoutBottomNav.visibility = View.GONE
        }
    }

    override fun onBackPressed() {
        if(currentDesID == R.id.fragmentHome ||
            currentDesID == R.id.fragmentSaved ||
            currentDesID == R.id.fragmentCart ||
            currentDesID == R.id.fragmentSearch) {
            finish()

            return
        }

        super.onBackPressed()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.layoutHome.setOnClickListener {
            navController.navigate(R.id.fragmentHome)
        }

        binding.layoutSaved.setOnClickListener {
            navController.navigate(R.id.fragmentSaved)
        }

        binding.layoutCart.setOnClickListener {
            navController.navigate(R.id.fragmentCart)
        }

        binding.layoutSearch.setOnClickListener {
            navController.navigate(R.id.fragmentSearch)
        }
    }

    override fun onResume() {
        super.onResume()
        navController.addOnDestinationChangedListener(navCtrlDesChangeListener)
    }

    override fun onPause() {
        super.onPause()
        navController.removeOnDestinationChangedListener(navCtrlDesChangeListener)
    }

    private fun changeActiveBottomNavBarIcon(destinationID: Int) {
        when(destinationID) {
            R.id.fragmentHome -> {
                binding.ivHome.setImageResource(R.drawable.ic_home_selected)
                binding.ivSaved.setImageResource(R.drawable.ic_save)
                binding.ivCart.setImageResource(R.drawable.ic_cart)
                binding.ivSearch.setImageResource(R.drawable.ic_search)

                binding.ivHomeSelector.visibility = View.VISIBLE
                binding.ivSavedSelector.visibility = View.INVISIBLE
                binding.ivCartSelector.visibility = View.INVISIBLE
                binding.ivSearchSelector.visibility = View.INVISIBLE
            }
            R.id.fragmentSaved -> {
                binding.ivHome.setImageResource(R.drawable.ic_home)
                binding.ivSaved.setImageResource(R.drawable.ic_saved_selected)
                binding.ivCart.setImageResource(R.drawable.ic_cart)
                binding.ivSearch.setImageResource(R.drawable.ic_search)

                binding.ivHomeSelector.visibility = View.INVISIBLE
                binding.ivSavedSelector.visibility = View.VISIBLE
                binding.ivCartSelector.visibility = View.INVISIBLE
                binding.ivSearchSelector.visibility = View.INVISIBLE
            }
            R.id.fragmentCart -> {
                binding.ivHome.setImageResource(R.drawable.ic_home)
                binding.ivSaved.setImageResource(R.drawable.ic_save)
                binding.ivCart.setImageResource(R.drawable.ic_cart_selected)
                binding.ivSearch.setImageResource(R.drawable.ic_search)

                binding.ivHomeSelector.visibility = View.INVISIBLE
                binding.ivSavedSelector.visibility = View.INVISIBLE
                binding.ivCartSelector.visibility = View.VISIBLE
                binding.ivSearchSelector.visibility = View.INVISIBLE
            }
            R.id.fragmentSearch -> {
                binding.ivHome.setImageResource(R.drawable.ic_home)
                binding.ivSaved.setImageResource(R.drawable.ic_save)
                binding.ivCart.setImageResource(R.drawable.ic_cart)
                binding.ivSearch.setImageResource(R.drawable.ic_search_selected)

                binding.ivHomeSelector.visibility = View.INVISIBLE
                binding.ivSavedSelector.visibility = View.INVISIBLE
                binding.ivCartSelector.visibility = View.INVISIBLE
                binding.ivSearchSelector.visibility = View.VISIBLE
            }
            else -> {
                binding.ivHome.setImageResource(R.drawable.ic_home_selected)
                binding.ivSaved.setImageResource(R.drawable.ic_save)
                binding.ivCart.setImageResource(R.drawable.ic_cart)
                binding.ivSearch.setImageResource(R.drawable.ic_search)

                binding.ivHomeSelector.visibility = View.VISIBLE
                binding.ivSavedSelector.visibility = View.INVISIBLE
                binding.ivCartSelector.visibility = View.INVISIBLE
                binding.ivSearchSelector.visibility = View.INVISIBLE
            }
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, MainActivity::class.java)
            return intent
        }
    }
}