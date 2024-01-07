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
import com.zawmoehtike.sportcommerce.presentation.features.filter.FilterActivity
import com.zawmoehtike.sportcommerce.presentation.features.home.adapters.CategoryRecyclerAdapter
import com.zawmoehtike.sportcommerce.presentation.features.home.adapters.ProductRecyclerPagerAdapter
import com.zawmoehtike.sportcommerce.presentation.viewdata.CategoryViewData
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

@AndroidEntryPoint
class SavedFragment: Fragment() {

    private var isFirstTime: Boolean = true

    private val viewModel: HomeViewModel by viewModels()

    private val binding: FragmentSavedBinding by lazy {
        FragmentSavedBinding.inflate(layoutInflater)
    }

    private val categoryRecyclerAdapter by lazy {
        CategoryRecyclerAdapter(
            onClick = {

            }
        )
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

        binding.rvBrands.adapter = categoryRecyclerAdapter
        categoryRecyclerAdapter.submitList(CategoryViewData().getCategoryVDList())

        binding.rvProducts.adapter = productRecyclerPagerAdapter
        val productNewEndReachedListener: EndReachedListener = EndReachedListener(binding.rvProducts) {
            if(!productPaginationParam.isLoading && !productPaginationParam.isPageEnded) {
                if(productPaginationParam.currentPage > 1) {
                    loadProductsNew()
                }
            }
        }
        binding.rvProducts.addOnScrollListener(productNewEndReachedListener)

        binding.ivFilter.setOnClickListener {
            startActivity(FilterActivity.newIntent(requireContext()))
        }

        binding.etSearch.setOnClickListener {
            val direction = SavedFragmentDirections.savedToSearch()
            findNavController().navigate(direction)
        }

        binding.ivCart.setOnClickListener {
            val direction = SavedFragmentDirections.savedToCart()
            findNavController().navigate(direction)
        }

        binding.ivMenu.setOnClickListener {
            startActivity(FilterActivity.newIntent(requireContext()))
        }
    }

    private fun loadProductsNew() {
        viewModel.loadSavedProductNewPage("${productPaginationParam.currentPage}") {
            Timber.i("calling loadProductsNew()")

            if(productPaginationParam.isFirstPage()) {
                productRecyclerPagerAdapter.clearItems()
            }

            if(it is ListViewState.Success) {
                productPaginationParam.isLoading = false

                productPaginationParam.currentPage++

                productRecyclerPagerAdapter.appendItems(it.value)

                productRecyclerPagerAdapter.setLoading(false)
            } else if(it is ListViewState.Loading) {
                productPaginationParam.isLoading = true

                productRecyclerPagerAdapter.setLoading(true)
            } else if(it is ListViewState.Error) {
                productPaginationParam.isLoading = false

                //Toast.makeText(context, it.errorMessage, Toast.LENGTH_SHORT).show()

                productRecyclerPagerAdapter.setLoading(false)
            } else if(it is ListViewState.NoMoreContent) {
                productPaginationParam.isLoading = false
                productPaginationParam.isPageEnded = true

                productRecyclerPagerAdapter.setLoading(false)
            } else {
                productPaginationParam.isLoading = false

                productRecyclerPagerAdapter.setLoading(false)
            }
        }
    }
}