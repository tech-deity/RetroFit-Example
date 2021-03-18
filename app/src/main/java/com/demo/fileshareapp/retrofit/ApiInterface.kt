package com.demo.fileshareapp.retrofit

import com.demo.fileshareapp.model.DataModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiInterface {

    @GET("photos")
    fun getPhotos(): Call<List<DataModel>>

}
