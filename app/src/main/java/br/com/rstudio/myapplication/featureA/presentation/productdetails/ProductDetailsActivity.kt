package br.com.rstudio.myapplication.featureA.presentation.productdetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel

class ProductDetailsActivity : AppCompatActivity() {

    private lateinit var textView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_product_details)
        setViews()
        setProductDetails()
    }

    private fun setViews() {
        textView = findViewById(R.id.textView)
    }

    private fun setProductDetails() {
        textView.text = intent.getParcelableExtra<ProductDetailsModel>(MODEL).toString()
    }

    companion object {
        private const val MODEL = "model"

        fun start(context: Context, model: ProductDetailsModel) {
            val intent = Intent(context, ProductDetailsActivity::class.java).apply {
                putExtra(MODEL, model)
            }
            context.startActivity(intent)
        }
    }
}