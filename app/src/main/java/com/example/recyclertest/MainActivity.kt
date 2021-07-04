package com.example.recyclertest

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import coil.load
import com.example.recyclertest.model.Countries
import com.example.recyclertest.network.CountriesService
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var countriesList = listOf<Countries.Result>()
        //val countryList = mutableListOf<com.example.recyclertest.Country>()
        var countriesService = CountriesService.getCountriesDataService()

        imageView.load("https://via.placeholder.com/600/92c952")

        button.setOnClickListener() {

            recycler.layoutManager = LinearLayoutManager(this)
            //recycler.layoutManager = GridLayoutManager(this, 2)

            CoroutineScope(Dispatchers.IO).launch {
                val response = countriesService.getCountriesData()
                withContext(Dispatchers.Main){
                    if(response.isSuccessful){
                        countriesList = response.body()?.result as List<Countries.Result>
                        recycler.adapter = RecyclerAdapter(countriesList)


                    }
                }
            }
        }
    }
}