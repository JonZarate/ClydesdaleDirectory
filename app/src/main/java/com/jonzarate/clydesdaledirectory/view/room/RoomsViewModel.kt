package com.jonzarate.clydesdaledirectory.view.room

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonzarate.clydesdaledirectory.data.model.Room
import com.jonzarate.clydesdaledirectory.data.repo.RoomsRepository
import kotlinx.coroutines.launch

class RoomsViewModel(
    private val repo: RoomsRepository
) : ViewModel() {

    val rooms = MutableLiveData<List<Room>>()

    init {
        viewModelScope.launch {
            rooms.postValue(repo.getRooms())
        }
    }

}