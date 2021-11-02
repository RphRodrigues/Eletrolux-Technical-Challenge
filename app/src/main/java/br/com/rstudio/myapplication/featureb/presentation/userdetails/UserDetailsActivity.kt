package br.com.rstudio.myapplication.featureb.presentation.userdetails

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureb.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.featureb.presentation.view.LoadImageView
import org.koin.android.viewmodel.ext.android.viewModel

class UserDetailsActivity : AppCompatActivity() {

    private val viewModel by viewModel<UserDetailsViewModel>()

    private lateinit var bioView: TextView
    private lateinit var nameView: TextView
    private lateinit var imageProfileView: LoadImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_details)

        setupViews()
        setupObservers()
        initialize()
    }

    private fun setupViews() {
        bioView = findViewById(R.id.bio)
        nameView = findViewById(R.id.name)
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
        bioView.text = getString(R.string.user_details_bio, user.bio.getOrDefault())
        nameView.text = getString(R.string.user_details_name, user.name.getOrDefault())
        imageProfileView.load(user.avatarUrl)
    }

    private fun String?.getOrDefault(): String {
        return this ?: getString(R.string.description_unknown)
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