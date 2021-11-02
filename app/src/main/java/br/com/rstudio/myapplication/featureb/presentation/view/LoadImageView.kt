package br.com.rstudio.myapplication.featureb.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import android.widget.ImageView
import br.com.rstudio.myapplication.R
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy

class LoadImageView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    private val loadImageView by lazy { findViewById<ImageView>(R.id.load_image_view) }

    init {
        inflate(context, R.layout.load_image_view, this)
    }

    fun load(url: String) {
        Glide.with(this)
            .load(url)
            .centerCrop()
            .diskCacheStrategy(DiskCacheStrategy.ALL)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(loadImageView)
    }
}