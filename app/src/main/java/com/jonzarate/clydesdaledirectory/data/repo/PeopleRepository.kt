package com.jonzarate.clydesdaledirectory.data.repo

import com.jonzarate.clydesdaledirectory.data.net.DirectoryApi

class PeopleRepository (
    private val api: DirectoryApi
) {

    suspend fun getPeople() = api.getPeople().sortedBy { person -> person.firstName }

    suspend fun getPerson(id: Int) = api.getPerson(id)

}