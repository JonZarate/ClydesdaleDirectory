package com.jonzarate.clydesdaledirectory.data.model

data class Person (
    val id: Int,
    val firstName: String,
    val lastName: String,
    val avatar: String,
    val jobTitle: String,
    val phone: String,
    val favouriteColor: String,
    val email: String
)