package com.example.recyclertest.network

import com.example.recyclertest.model.Countries
import retrofit2.Response
import retrofit2.http.GET

interface CountriesAPI {
    @GET ("countries")
    suspend fun getCountriesData():Response<Countries>
}