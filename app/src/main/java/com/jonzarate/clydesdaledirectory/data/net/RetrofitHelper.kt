package com.jonzarate.clydesdaledirectory.data.net

import retrofit2.Converter
import retrofit2.Retrofit

object RetrofitHelper {
    fun newInstance(baseUrl: String, converter: Converter.Factory): DirectoryApi {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(converter)
            .build()
            .create(DirectoryApi::class.java)
    }
}