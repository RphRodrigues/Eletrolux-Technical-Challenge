package br.com.rstudio.myapplication.core.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.core.ImageLoader
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

class LoadImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr), KoinComponent {

    private val imageLoader by inject<ImageLoader>()

    private val imageView by lazy { findViewById<ImageView>(R.id.load_image_view) }

    init {
        inflate(context, R.layout.load_image_view, this)
    }

    fun load(url: String) {
        imageLoader.load(url, imageView)
    }
}