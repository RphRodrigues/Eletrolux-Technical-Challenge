package br.com.rstudio.myapplication.featureA.presentation.productslist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureA.domain.model.ProductDetailsModel
import br.com.rstudio.myapplication.featureA.domain.model.ProductItemModel
import br.com.rstudio.myapplication.featureA.presentation.productdetails.ProductDetailsActivity
import br.com.rstudio.myapplication.featureA.presentation.productslist.view.ProductItemView
import org.koin.android.viewmodel.ext.android.viewModel

class ProductListActivity : AppCompatActivity() {

    private val viewModel by viewModel<ProductsListViewModel>()

    private lateinit var containerView: LinearLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setViews()
        setObservers()

        loadProducts()
    }

    private fun setViews() {
        containerView = findViewById(R.id.containerView)
    }

    private fun setObservers() {
        viewModel.products
            .observe(this) { product ->
                bindProduct(product)
            }

        viewModel.productDetails
            .observe(this) { details ->
                openProductDetailsScreen(details)
            }
    }

    private fun loadProducts() {
        viewModel.loadProducts()
    }

    private fun loadProductDetails(id: String) {
        viewModel.loadProductDetails(id)
    }

    private fun bindProduct(model: ProductItemModel) {
        ProductItemView(this).apply {
            bind(model, ::loadProductDetails)
        }.also {
            containerView.addView(it)
        }
    }

    private fun openProductDetailsScreen(model: ProductDetailsModel) {
        ProductDetailsActivity.start(this, model)
    }
}