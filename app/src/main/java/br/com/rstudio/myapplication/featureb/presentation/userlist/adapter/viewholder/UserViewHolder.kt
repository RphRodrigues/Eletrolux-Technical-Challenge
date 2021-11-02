package br.com.rstudio.myapplication.featureb.presentation.userlist.adapter.viewholder

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.presentation.view.LoadImageView

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val contentView = itemView.findViewById<ViewGroup>(R.id.contentView)
    private val imageView = itemView.findViewById<LoadImageView>(R.id.imageView)
    private val labelView = itemView.findViewById<TextView>(R.id.labelView)

    fun bind(user: UserModel, onItemClickListener: (id: Int) -> Unit) = with(user) {
        labelView.text = login
        imageView.load(avatarUrl)
        contentView.setOnClickListener { onItemClickListener.invoke(id) }
    }
}