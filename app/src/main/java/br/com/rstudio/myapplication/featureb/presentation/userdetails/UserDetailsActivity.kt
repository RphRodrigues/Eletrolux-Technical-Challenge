package br.com.rstudio.myapplication.featureb.presentation.userdetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.presentation.view.LoadImageView
import org.koin.android.viewmodel.ext.android.viewModel

class UserDetailsActivity : AppCompatActivity() {

    private val viewModel by viewModel<UserDetailsViewModel>()

    private lateinit var textView: TextView
    private lateinit var imageProfileView: LoadImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        setupViews()
        setupObservers()
        initialize()
    }

    private fun setupViews() {
        textView = findViewById(R.id.textView)
        imageProfileView = findViewById(R.id.image_profile)
    }

    private fun setupObservers() {
        viewModel.user
            .observe(this) { user ->
                bindUserDetails(user)
            }
    }

    private fun initialize() {
        intent.getParcelableExtra<UserDetailsModel>(MODEL)?.let { viewModel.init(it) }
    }

    private fun bindUserDetails(user: UserDetailsModel) {
        textView.text = user.bio
        imageProfileView.load(user.avatarUrl)
    }

    companion object {
        private const val MODEL = "model"

        fun newIntent(context: Context, model: UserDetailsModel?): Intent {
            return Intent(context, UserDetailsActivity::class.java).apply {
                putExtra(MODEL, model)
            }
        }
    }
}