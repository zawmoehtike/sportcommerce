package com.zawmoehtike.sportcommerce.presentation.features.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.zawmoehtike.sportcommerce.appbase.common.utils.EndReachedListener
import com.zawmoehtike.sportcommerce.appbase.core.TraditionalPaginationParams
import com.zawmoehtike.sportcommerce.appbase.core.viewstate.ListViewState
import com.zawmoehtike.sportcommerce.databinding.FragmentSavedBinding
import com.zawmoehtike.sportcommerce.presentation.features.home.adapters.ProductRecyclerPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SavedFragment: Fragment() {

    private var isFirstTime: Boolean = true

    private val viewModel: HomeViewModel by viewModels()

    private val binding: FragmentSavedBinding by lazy {
        FragmentSavedBinding.inflate(layoutInflater)
    }

    private val productPaginationParam: TraditionalPaginationParams by lazy {
        TraditionalPaginationParams()
    }

    private val productRecyclerPagerAdapter by lazy {
        ProductRecyclerPagerAdapter(
            onClick = {
                val direction = SavedFragmentDirections.savedToProductDetails(productID = "${it.id}")
                findNavController().navigate(direction)
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

        if(isFirstTime) {
            loadProductsNew()

            isFirstTime = false
        }

        binding.rvProducts.adapter = productRecyclerPagerAdapter
        val productNewEndReachedListener: EndReachedListener = EndReachedListener(binding.rvProducts) {
            if(!productPaginationParam.isLoading && !productPaginationParam.isPageEnded) {
                if(productPaginationParam.currentPage > 1) {
                    loadProductsNew()
                }
            }
        }
        binding.rvProducts.addOnScrollListener(productNewEndReachedListener)
    }

    private fun loadProductsNew() {
        viewModel.loadProductNewPage("${productPaginationParam.currentPage}") {
            Timber.i("calling loadProductsNew()")

            if(productPaginationParam.isFirstPage()) {
                productRecyclerPagerAdapter.clearItems()
            }

            if(it is ListViewState.Success) {
                productPaginationParam.isLoading = false

                productPaginationParam.currentPage++

                productRecyclerPagerAdapter.appendItems(it.value)
            } else if(it is ListViewState.Loading) {
                productPaginationParam.isLoading = true
            } else if(it is ListViewState.Error) {
                productPaginationParam.isLoading = false

                //Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()
            } else if(it is ListViewState.NoMoreContent) {
                productPaginationParam.isLoading = false
                productPaginationParam.isPageEnded = true
            } else {
                productPaginationParam.isLoading = false
            }
        }
    }
}