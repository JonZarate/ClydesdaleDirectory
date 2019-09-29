package com.jonzarate.clydesdaledirectory.view.room

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jonzarate.clydesdaledirectory.data.repo.RoomsRepository

class RoomsViewModelFactory (
    private val repo: RoomsRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return RoomsViewModel(repo) as T
    }
}