package br.com.rstudio.myapplication.featureb.presentation.userlist.adapter.viewholder

import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.rstudio.myapplication.R
import br.com.rstudio.myapplication.featureb.domain.model.UserModel
import br.com.rstudio.myapplication.featureb.presentation.view.LoadImageView

class UserViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    private val contentView = itemView.findViewById<ViewGroup>(R.id.content_view)
    private val imageView = itemView.findViewById<LoadImageView>(R.id.image_view)
    private val labelView = itemView.findViewById<TextView>(R.id.label_view)

    fun bind(user: UserModel, onItemClickListener: (id: Int) -> Unit) = with(user) {
        labelView.text = login
        imageView.load(avatarUrl)
        contentView.setOnClickListener { onItemClickListener.invoke(id) }
    }
}