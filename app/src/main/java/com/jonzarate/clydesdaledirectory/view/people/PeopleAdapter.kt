package com.jonzarate.clydesdaledirectory.view.people

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.clydesdaledirectory.data.model.Person
import com.jonzarate.clydesdaledirectory.databinding.ItemPersonBinding

class PeopleAdapter(
    private val listener: OnUserClickListener
) : RecyclerView.Adapter<PeopleViewHolder>() {

    interface OnUserClickListener {
        fun onUserClick(id: Int)
    }

    var people: List<Person>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PeopleViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemPersonBinding.inflate(inflater, parent, false)
        return PeopleViewHolder(binding, listener)
    }

    override fun getItemCount() = people?.size ?: 0

    override fun onBindViewHolder(holder: PeopleViewHolder, position: Int) {
        people?.get(position)?.run {
            holder.bind(this)
        }
    }
}