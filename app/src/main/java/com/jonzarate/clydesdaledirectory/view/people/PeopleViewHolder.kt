package com.jonzarate.clydesdaledirectory.view.people

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.clydesdaledirectory.data.model.Person
import com.jonzarate.clydesdaledirectory.databinding.ItemPersonBinding

class PeopleViewHolder(
    private val binding: ItemPersonBinding,
    private val listener: PeopleAdapter.OnUserClickListener
) : RecyclerView.ViewHolder(binding.root) {

    init {
        binding.root.setOnClickListener(View.OnClickListener {
            binding.person?.id?.also {
                listener.onUserClick(it)
            }
        })
    }

    fun bind(person: Person) {
        binding.person = person
    }
}