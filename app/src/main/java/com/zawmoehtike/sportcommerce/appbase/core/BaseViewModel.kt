package com.zawmoehtike.sportcommerce.appbase.core

import androidx.lifecycle.ViewModel
import com.zawmoehtike.sportcommerce.appbase.exception.ExceptionToStringMapper
import javax.inject.Inject

abstract class BaseViewModel : ViewModel() {
    @Inject lateinit var exception: ExceptionToStringMapper
}