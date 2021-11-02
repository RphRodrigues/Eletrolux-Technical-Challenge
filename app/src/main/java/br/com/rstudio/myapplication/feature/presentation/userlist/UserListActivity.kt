package br.com.rstudio.myapplication.feature.presentation.userlist

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.feature.domain.model.UserDetailsModel
import br.com.rstudio.myapplication.feature.domain.model.UserModel
import br.com.rstudio.myapplication.feature.presentation.userdetails.UserDetailsActivity
import br.com.rstudio.myapplication.feature.presentation.userlist.adapter.UserListAdapter
import br.com.rstudio.myapplication.feature.presentation.view.LoadingView
import org.koin.android.viewmodel.ext.android.viewModel

class UserListActivity : AppCompatActivity() {

    private val viewModel by viewModel<UserListViewModel>()

    private lateinit var recyclerView: RecyclerView
    private lateinit var loadingView: LoadingView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        setupViews()
        setupRecyclerView()
        setupObservers()

        loadUsers()
    }

    private fun setupViews() {
        recyclerView = findViewById(R.id.recycle_view)
        loadingView = findViewById(R.id.loading_view)
    }

    private fun setupRecyclerView() {
        recyclerView.apply {
            setHasFixedSize(true)
            adapter = UserListAdapter(::onItemClickListener)
        }
    }

    private fun setupObservers() {
        viewModel.users
            .observe(this) { users ->
                bindUsers(users)
            }

        viewModel.user
            .observe(this) { userDetails ->
                openDetailsScreen(userDetails)
            }

        viewModel.error
            .observe(this) { errorMessage ->
                showError(errorMessage)
            }

        viewModel.isLoading
            .observe(this) { isLoading ->
                showLoading(isLoading)
            }
    }

    private fun loadUsers() {
        viewModel.loadUsers()
    }

    private fun bindUsers(users: List<UserModel>) {
        (recyclerView.adapter as? UserListAdapter)?.addItems(users)
    }

    private fun onItemClickListener(id: Int) {
        loadUserDetails(id)
    }

    private fun loadUserDetails(id: Int) {
        viewModel.loadUserDetails(id)
    }

    private fun openDetailsScreen(model: UserDetailsModel?) {
        val intent = UserDetailsActivity.newIntent(this, model)
        startActivity(intent)
    }

    private fun showLoading(isLoading: Boolean) {
        loadingView.isVisible = isLoading
    }

    private fun showError(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }
}