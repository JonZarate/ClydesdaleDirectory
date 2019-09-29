package com.jonzarate.clydesdaledirectory.view.person

import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.clydesdaledirectory.data.model.Person
import com.jonzarate.clydesdaledirectory.databinding.ItemPersonDetailHeaderBinding

class PersonHeaderViewHolder(
    private val binding: ItemPersonDetailHeaderBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(person: Person) {
        binding.person = person
    }

}