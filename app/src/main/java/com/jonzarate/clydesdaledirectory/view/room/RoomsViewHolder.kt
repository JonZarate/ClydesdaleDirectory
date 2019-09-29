package com.jonzarate.clydesdaledirectory.view.room

import androidx.recyclerview.widget.RecyclerView
import com.jonzarate.clydesdaledirectory.data.model.Room
import com.jonzarate.clydesdaledirectory.databinding.ItemRoomBinding

class RoomsViewHolder(
    private val binding: ItemRoomBinding
) : RecyclerView.ViewHolder(binding.root) {

    fun bind(room: Room) {
        binding.room = room
    }

}