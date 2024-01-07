package com.zawmoehtike.sportcommerce.presentation.features.product_details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.LinearSnapHelper
import com.zawmoehtike.sportcommerce.R
import com.zawmoehtike.sportcommerce.appbase.core.viewstate.ViewState
import com.zawmoehtike.sportcommerce.databinding.FragmentProductDetailsBinding
import com.zawmoehtike.sportcommerce.domain.home.model.SizeModel
import com.zawmoehtike.sportcommerce.presentation.features.home.HomeViewModel
import com.zawmoehtike.sportcommerce.presentation.features.home.adapters.ColorRecyclerAdapter
import com.zawmoehtike.sportcommerce.presentation.features.home.adapters.SizeRecyclerAdapter
import com.zawmoehtike.sportcommerce.presentation.features.product_details.adapters.ProductPhotoRecyclerAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ProductDetailsFragment: Fragment() {

    private var euSizeList: List<SizeModel.SizeValue> = emptyList()
    private var ukSizeList: List<SizeModel.SizeValue> = emptyList()
    private var usSizeList: List<SizeModel.SizeValue> = emptyList()
    private var productID: String = "0"
    private val viewModel: HomeViewModel by viewModels()

    private val navArgs by navArgs<ProductDetailsFragmentArgs>()

    private val binding: FragmentProductDetailsBinding by lazy {
        FragmentProductDetailsBinding.inflate(layoutInflater)
    }

    private val productPhotoRecyclerAdapter by lazy {
        ProductPhotoRecyclerAdapter(
            onClick = {

            }
        )
    }

    private val sizeRecyclerAdapter by lazy {
        SizeRecyclerAdapter(
            onClick = {

            }
        )
    }

    private val colorRecyclerAdapter by lazy {
        ColorRecyclerAdapter(
            onClick = {

            }
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rvSizes.adapter = sizeRecyclerAdapter
        binding.rvColors.adapter = colorRecyclerAdapter

        productID = navArgs.productID

        viewModel.loadProductDetails(productID) {
            if(it is ViewState.Success) {
                with(it.value) {
                    with(binding) {
                        tvCategory.text = "Men's Shoes"
                        tvRating.text = "($rating)"
                        tvName.text = "$name"
                        tvPrice.text = "$currency $price"
                        tvMoreDescription.text = "$description"

                        val snapHelper = LinearSnapHelper()
                        snapHelper.attachToRecyclerView(binding.rvProductPhotos)
                        binding.rvProductPhotos.adapter = productPhotoRecyclerAdapter
                        val productImageList = listOf(image, image, image)
                        productPhotoRecyclerAdapter.submitList(productImageList)
                        lifecycleScope.launch(Dispatchers.Main) {
                            binding.recyclerViewIndicator.setRecyclerView(binding.rvProductPhotos)
                        }

                        usSizeList = size?.us?: emptyList()
                        ukSizeList = size?.uk?: emptyList()
                        euSizeList = size?.eu?: emptyList()

                        sizeRecyclerAdapter.submitList(usSizeList)
                        colorRecyclerAdapter.submitList(color)

                        startProductPhotoAutoScroll(productImageList.size)
                    }
                }
            } else if(it is ViewState.Loading) {

            } else if(it is ViewState.Error) {
                Toast.makeText(context, "${it.errorMessage}", Toast.LENGTH_SHORT).show()
            }
        }

        binding.tvUSSize.setOnClickListener {
            sizeRecyclerAdapter.submitList(usSizeList)

            binding.tvUSSize.setTextAppearance(R.style.KanitBold_M)
            binding.tvUKSize.setTextAppearance(R.style.KanitRegular_M)
            binding.tvEUSize.setTextAppearance(R.style.KanitRegular_M)
        }

        binding.tvUKSize.setOnClickListener {
            sizeRecyclerAdapter.submitList(ukSizeList)

            binding.tvUKSize.setTextAppearance(R.style.KanitBold_M)
            binding.tvUSSize.setTextAppearance(R.style.KanitRegular_M)
            binding.tvEUSize.setTextAppearance(R.style.KanitRegular_M)
        }

        binding.tvEUSize.setOnClickListener {
            sizeRecyclerAdapter.submitList(euSizeList)

            binding.tvEUSize.setTextAppearance(R.style.KanitBold_M)
            binding.tvUSSize.setTextAppearance(R.style.KanitRegular_M)
            binding.tvUKSize.setTextAppearance(R.style.KanitRegular_M)
        }

        binding.ivReadMoreDescription.setOnClickListener {
            if(binding.tvMoreDescription.isVisible) binding.tvMoreDescription.visibility = View.GONE
            else binding.tvMoreDescription.visibility = View.VISIBLE
        }

        binding.ivReadMorePolicy.setOnClickListener {
            if(binding.tvMorePolicy.isVisible) binding.tvMorePolicy.visibility = View.GONE
            else binding.tvMorePolicy.visibility = View.VISIBLE
        }

        binding.ivIncrease.setOnClickListener {
            var qty = binding.tvCurrentQuantity.text.toString().toInt()
            qty++
            binding.tvCurrentQuantity.text = "$qty"
        }

        binding.ivDecrease.setOnClickListener {
            var qty = binding.tvCurrentQuantity.text.toString().toInt()
            if(qty > 1) qty--
            binding.tvCurrentQuantity.text = "$qty"
        }

        binding.ivBack.setOnClickListener {
            findNavController().popBackStack()
        }
    }

    private fun startProductPhotoAutoScroll(size: Int) {
        var currentPage = 0

        lifecycleScope.launch {
            while (true) {
                launch(Dispatchers.Main) {
                    binding.rvProductPhotos.smoothScrollToPosition(currentPage)
                }

                delay(2000)

                currentPage++

                if(currentPage == size) currentPage = 0
            }
        }
    }
}