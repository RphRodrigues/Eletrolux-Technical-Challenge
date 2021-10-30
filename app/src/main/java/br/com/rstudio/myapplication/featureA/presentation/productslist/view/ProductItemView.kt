package br.com.rstudio.myapplication.featureA.presentation.productslist.view

import android.content.Context
import android.util.AttributeSet
import android.util.TypedValue
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.content.ContextCompat
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureA.domain.model.ProductItemModel

class ProductItemView(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : LinearLayout(context, attrs, defStyleAttr) {

    private val titleView: TextView by lazy { findViewById(R.id.titleView) }

    init {
        orientation = VERTICAL
        configRippleEffect()
        inflate(context, R.layout.product_item_view, this)
    }

    private fun configRippleEffect() {
        isClickable = true
        isFocusable = true

        val typeValue = TypedValue()
        context.theme.resolveAttribute(R.attr.selectableItemBackground, typeValue, true)
        background = ContextCompat.getDrawable(context, typeValue.resourceId)
    }

    fun bind(model: ProductItemModel, listener: (id: String) -> Unit) {
        titleView.text = model.name
        setOnClickListener { listener(model.id) }
    }
}