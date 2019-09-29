package com.jonzarate.clydesdaledirectory.view.people

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jonzarate.clydesdaledirectory.data.repo.PeopleRepository

class PeopleViewModelFactory (
    private val repo: PeopleRepository
) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return PeopleViewModel(repo) as T
    }
}