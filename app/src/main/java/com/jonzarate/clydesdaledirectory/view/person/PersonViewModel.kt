package com.jonzarate.clydesdaledirectory.view.person

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jonzarate.clydesdaledirectory.data.model.Person
import com.jonzarate.clydesdaledirectory.data.repo.PeopleRepository
import kotlinx.coroutines.launch

class PersonViewModel(
    private val id: Int,
    private val repo: PeopleRepository
) : ViewModel() {

    val person = MutableLiveData<Person>()

    init {
        viewModelScope.launch {
            person.postValue(repo.getPerson(id))
        }
    }

}