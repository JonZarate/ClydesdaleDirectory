package com.jonzarate.clydesdaledirectory.view.person

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jonzarate.clydesdaledirectory.data.repo.PeopleRepository

class PersonViewModelFactory (
    private val id: Int,
    private val repo: PeopleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PersonViewModel(id, repo) as T
    }
}