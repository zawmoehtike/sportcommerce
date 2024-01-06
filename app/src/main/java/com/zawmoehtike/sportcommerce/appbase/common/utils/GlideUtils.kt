package com.zawmoehtike.sportcommerce.appbase.common.utils

import android.net.Uri
import android.widget.ImageView
import com.bumptech.glide.Glide

object GlideUtils {

    fun ImageView.loadCenterCropImageFromUrl(url: String?) {
        Glide
            .with(this)
            .load(url)
            .centerCrop()
            .into(this)
    }

    fun ImageView.loadCenterCropImageFromUri(uri: Uri?) {
        Glide
            .with(this)
            .load(uri)
            .centerCrop()
            .into(this)
    }
}