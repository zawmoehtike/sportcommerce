package com.zawmoehtike.sportcommerce.presentation.features.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.zawmoehtike.sportcommerce.databinding.FragmentProductDetailsBinding

class ProductDetailsFragment: Fragment() {

    private val binding: FragmentProductDetailsBinding by lazy {
        FragmentProductDetailsBinding.inflate(layoutInflater)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }
}