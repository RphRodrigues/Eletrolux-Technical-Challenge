package br.com.rstudio.myapplication.featureb.presentation.userlist.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.presentation.userlist.adapter.viewholder.UserViewHolder

class UserAdapter(
    private val onItemClickListener: (id: Int) -> Unit
) : RecyclerView.Adapter<UserViewHolder>() {

    private var users: List<UserModel> = emptyList()

    fun addItems(users: List<UserModel>) {
        this.users = users
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UserViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.user_item_view, parent, false)
        return UserViewHolder(view)
    }

    override fun onBindViewHolder(holder: UserViewHolder, position: Int) {
        holder.bind(users[position], onItemClickListener)
    }

    override fun getItemCount(): Int = users.size
}