package com.zawmoehtike.sportcommerce.presentation.features.filter

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.zawmoehtike.sportcommerce.databinding.ActivityFilterBinding

class FilterActivity: AppCompatActivity() {

    private val binding: ActivityFilterBinding by lazy {
        ActivityFilterBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, FilterActivity::class.java)
            return intent
        }
    }
}