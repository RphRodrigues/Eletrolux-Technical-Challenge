package br.com.rstudio.myapplication.core

import android.widget.ImageView
import com.bumptech.glide.RequestManager

interface ImageLoader {
    fun load(url: String, targetView: ImageView)
}

class GlideImageLoader(private val glide: RequestManager) : ImageLoader {

    override fun load(url: String, targetView: ImageView) {
        glide
            .load(url)
            .into(targetView)
    }
}