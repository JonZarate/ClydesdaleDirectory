package com.jonzarate.clydesdaledirectory.view.person

import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.clydesdaledirectory.databinding.ItemPersonDetailTextBinding

class PersonTextViewHolder(
    private val binding: ItemPersonDetailTextBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind (text: String, desc: String) {
        with (binding) {
            this.text = text
            this.description = desc
        }
    }

}