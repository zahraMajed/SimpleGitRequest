package com.example.simplegitrequest

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiInterface {
    @GET("people/")
    fun getDate(): Call<myData>?
}