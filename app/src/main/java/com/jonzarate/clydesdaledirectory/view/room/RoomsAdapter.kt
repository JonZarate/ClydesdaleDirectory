package com.jonzarate.clydesdaledirectory.view.room

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.clydesdaledirectory.data.model.Room
import com.jonzarate.clydesdaledirectory.databinding.ItemRoomBinding

class RoomsAdapter : RecyclerView.Adapter<RoomsViewHolder>() {

    var rooms: List<Room>? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomsViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemRoomBinding.inflate(inflater, parent, false)
        return RoomsViewHolder(binding)
    }

    override fun getItemCount() = rooms?.size ?: 0

    override fun onBindViewHolder(holder: RoomsViewHolder, position: Int) {
        rooms?.get(position)?.run {
            holder.bind(this)
        }
    }
}