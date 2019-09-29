package com.jonzarate.clydesdaledirectory.view.person

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.clydesdaledirectory.data.model.Person
import com.jonzarate.clydesdaledirectory.databinding.ItemPersonDetailHeaderBinding
import com.jonzarate.clydesdaledirectory.databinding.ItemPersonDetailTextBinding

class PersonAdapter : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    companion object {
        private const val VIEW_TYPE_HEADER = 0
        private const val VIEW_TYPE_DETAIL = 1
    }

    var person: Person? = null

    override fun getItemViewType(position: Int): Int {
        return when (position) {
            0 -> VIEW_TYPE_HEADER
            else -> VIEW_TYPE_DETAIL
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            VIEW_TYPE_HEADER -> {
                val binding = ItemPersonDetailHeaderBinding.inflate(inflater, parent, false)
                PersonHeaderViewHolder(binding)
            }
            else -> {
                val binding = ItemPersonDetailTextBinding.inflate(inflater, parent, false)
                PersonTextViewHolder(binding)
            }
        }
    }

    override fun getItemCount(): Int {
        return if (person != null) 5 else 0
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        person?.also {
            when (getItemViewType(position)) {
                VIEW_TYPE_HEADER -> {
                    (holder as? PersonHeaderViewHolder)?.bind(it)
                }
                VIEW_TYPE_DETAIL -> {
                    (holder as? PersonTextViewHolder)?.bind(
                        getItem(position), getItemDescription(position))
                }
            }
        }
    }

    private fun getItem(position: Int) : String {
        return person?.let {
            when(position) {
                1 -> it.jobTitle
                2 -> it.email
                3 -> it.phone
                4 -> it.favouriteColor
                else -> ""
            }
        } ?: ""
    }

    private fun getItemDescription(position: Int) : String {
        return when(position) {
            1 -> "Job"
            2 -> "Email"
            3 -> "Phone"
            4 -> "Favourite color"
            else -> ""
        }
    }
}