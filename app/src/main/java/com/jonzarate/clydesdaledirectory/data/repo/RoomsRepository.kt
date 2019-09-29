package com.jonzarate.clydesdaledirectory.data.repo

import com.jonzarate.clydesdaledirectory.data.net.DirectoryApi

class RoomsRepository (
    private val api: DirectoryApi
) {

    suspend fun getRooms() = api.getRooms()

}