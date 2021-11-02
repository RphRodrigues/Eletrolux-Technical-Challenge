package br.com.rstudio.myapplication.feature.presentation.view

import android.content.Context
import android.util.AttributeSet
import android.widget.FrameLayout
import br.com.rstudio.myapplication.R

class LoadingView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : FrameLayout(context, attrs, defStyleAttr) {

    init {
        inflate(context, R.layout.loading_view, this)
    }
}