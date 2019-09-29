package com.jonzarate.clydesdaledirectory.view.people

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonzarate.clydesdaledirectory.arch.SingleLiveEvent
import com.jonzarate.clydesdaledirectory.data.model.Person
import com.jonzarate.clydesdaledirectory.data.repo.PeopleRepository
import kotlinx.coroutines.launch

class PeopleViewModel(
    private val repo: PeopleRepository
) : ViewModel() {

    val people = MutableLiveData<List<Person>>()

    val launchPerson = SingleLiveEvent<Int>()

    init {
        viewModelScope.launch {
            people.postValue(repo.getPeople())
        }
    }

    fun onPersonClicked(id: Int) {
        launchPerson.postValue(id)
    }
}