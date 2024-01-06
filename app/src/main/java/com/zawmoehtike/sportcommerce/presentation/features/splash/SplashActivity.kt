package com.zawmoehtike.sportcommerce.presentation.features.splash

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.zawmoehtike.sportcommerce.R
import com.zawmoehtike.sportcommerce.presentation.features.onboarding.OnBoardingActivity
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        lifecycleScope.launch {
            delay(2000)

            startActivity(OnBoardingActivity.newIntent(this@SplashActivity))
            finish()
        }
    }
}