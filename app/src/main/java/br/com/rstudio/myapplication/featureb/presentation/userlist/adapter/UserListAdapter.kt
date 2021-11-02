package br.com.rstudio.myapplication.featureb.presentation.userlist.adapter

import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.core.ext.inflate
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.presentation.userlist.adapter.viewholder.UserViewHolder

class UserListAdapter(
    private val onItemClickListener: (id: Int) -> Unit
) : RecyclerView.Adapter<UserViewHolder>() {

    private var users: List<UserModel> = emptyList()

    fun addItems(users: List<UserModel>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = parent.inflate(R.layout.user_item_view)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position], onItemClickListener)
    }

    override fun getItemCount(): Int = users.size
}