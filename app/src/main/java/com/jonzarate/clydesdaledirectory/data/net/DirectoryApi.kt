package com.jonzarate.clydesdaledirectory.data.net

import com.jonzarate.clydesdaledirectory.data.model.People
import com.jonzarate.clydesdaledirectory.data.model.Person
import com.jonzarate.clydesdaledirectory.data.model.Rooms
import retrofit2.http.GET
import retrofit2.http.Path

interface DirectoryApi {

    @GET("people")
    suspend fun getPeople() : People

    @GET("people/{id}")
    suspend fun getPerson(@Path("id") id: Int) : Person

    @GET("rooms")
    suspend fun getRooms() : Rooms
}