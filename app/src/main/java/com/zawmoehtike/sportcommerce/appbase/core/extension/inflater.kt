package com.zawmoehtike.sportcommerce.appbase.core.extension

import android.content.Context
import android.view.LayoutInflater

/**
 * Created by Vincent on 2/13/20
 */
fun Context.inflater(): LayoutInflater {
    return LayoutInflater.from(this)
}
