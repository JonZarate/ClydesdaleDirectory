package com.jonzarate.clydesdaledirectory.arch

import com.jonzarate.clydesdaledirectory.BuildConfig
import com.jonzarate.clydesdaledirectory.data.net.DirectoryApi
import com.jonzarate.clydesdaledirectory.data.net.RetrofitHelper
import com.jonzarate.clydesdaledirectory.data.repo.PeopleRepository
import com.jonzarate.clydesdaledirectory.data.repo.RoomsRepository
import com.jonzarate.clydesdaledirectory.view.people.PeopleViewModelFactory
import com.jonzarate.clydesdaledirectory.view.person.PersonViewModelFactory
import com.jonzarate.clydesdaledirectory.view.room.RoomsViewModelFactory
import retrofit2.converter.gson.GsonConverterFactory

object Injection {

    @Volatile
    private var api: DirectoryApi? = null
    @Volatile
    private var people: PeopleRepository? = null
    @Volatile
    private var rooms: RoomsRepository? = null


    private fun getDirectoryApi() : DirectoryApi {
        return api ?: synchronized(this) {
            RetrofitHelper.newInstance(
                BuildConfig.ENDPOINT, GsonConverterFactory.create()
            ).apply {
                api = this
            }
        }
    }

    private fun getPeopleRepository() : PeopleRepository {
        return people ?: synchronized(this) {
            PeopleRepository(getDirectoryApi()).apply {
                people = this
            }
        }
    }

    private fun getRoomsRepository() : RoomsRepository {
        return rooms ?: synchronized(this) {
            RoomsRepository(getDirectoryApi()).apply {
                rooms = this
            }
        }
    }

    fun getPeopleViewModelFactory() = PeopleViewModelFactory(getPeopleRepository())

    fun getPersonViewModelFactory(id: Int) = PersonViewModelFactory(id, getPeopleRepository())

    fun getRoomsViewModelFactory() = RoomsViewModelFactory(getRoomsRepository())

}