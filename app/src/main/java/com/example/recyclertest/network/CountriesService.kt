package com.example.recyclertest.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object CountriesService
{
    private val BASE_URL = "https://api.printful.com/"

    fun getCountriesDataService():CountriesAPI {
        return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build().create(CountriesAPI::class.java)
    }
}