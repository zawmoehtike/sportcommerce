package com.zawmoehtike.sportcommerce.presentation.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.zawmoehtike.sportcommerce.databinding.FragmentSavedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SavedFragment: Fragment() {

    private val viewModel: HomeViewModel by viewModels()

    private val binding: FragmentSavedBinding by lazy {
        FragmentSavedBinding.inflate(layoutInflater)
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