package com.zawmoehtike.sportcommerce.presentation.features.home

import androidx.lifecycle.viewModelScope
import com.zawmoehtike.sportcommerce.appbase.core.BaseViewModel
import com.zawmoehtike.sportcommerce.appbase.core.viewstate.ListViewState
import com.zawmoehtike.sportcommerce.appbase.core.viewstate.ViewState
import com.zawmoehtike.sportcommerce.appbase.exception.ExceptionToStringMapper
import com.zawmoehtike.sportcommerce.domain.home.model.ProductModel
import com.zawmoehtike.sportcommerce.domain.home.usecase.GetProductDetails
import com.zawmoehtike.sportcommerce.domain.home.usecase.GetProductList
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getProductList: GetProductList,
    private val getProductDetails: GetProductDetails,
    private val exceptionToStringMapper: ExceptionToStringMapper
): BaseViewModel() {

    fun loadProductNewPage(currentPage: String, result: (ListViewState<List<ProductModel>>) -> Unit) {
        viewModelScope.launch {
            result.invoke(ListViewState.Loading())
            runCatching {
                val list = getProductList.execute(currentPage)

                if(list.isNotEmpty()) {
                    result.invoke(ListViewState.Success(list))
                } else {
                    result.invoke(ListViewState.NoMoreContent())
                }
            }.getOrElse {
                val errorMessage = exceptionToStringMapper.map(it)
                Timber.d(errorMessage)
                result.invoke(ListViewState.Error(errorMessage))
            }
        }
    }

    fun loadProductDetails(id: String, result: (ViewState<ProductModel>) -> Unit) {
        viewModelScope.launch {
            result.invoke(ViewState.Loading())
            runCatching {
                val data = getProductDetails.execute(id)

                result.invoke(ViewState.Success(data))
            }.getOrElse {
                val errorMessage = exceptionToStringMapper.map(it)
                Timber.d(errorMessage)
                result.invoke(ViewState.Error(errorMessage))
            }
        }
    }

}