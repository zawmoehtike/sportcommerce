package com.zawmoehtike.sportcommerce.presentation.features.onboarding

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.zawmoehtike.sportcommerce.appbase.common.utils.GlideUtils.loadCenterCropImageFromUrl
import com.zawmoehtike.sportcommerce.databinding.ActivityOnBoardingBinding
import com.zawmoehtike.sportcommerce.presentation.features.home.MainActivity

class OnBoardingActivity : AppCompatActivity() {

    private val binding: ActivityOnBoardingBinding by lazy {
        ActivityOnBoardingBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.ivSplash.loadCenterCropImageFromUrl("https://i.pinimg.com/originals/2f/8d/dd/2f8dddfc9134c8fcf3643aefb8d1bd33.gif")

        binding.btnStart.setOnClickListener {
            startActivity(MainActivity.newIntent(this))
            finish()
        }
    }

    companion object {
        fun newIntent(context: Context): Intent {
            val intent = Intent(context, OnBoardingActivity::class.java)
            return intent
        }
    }
}