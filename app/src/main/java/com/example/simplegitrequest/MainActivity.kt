package com.example.simplegitrequest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    lateinit var textV:TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textV=findViewById(R.id.textView)

        getData()
    }

    fun getData(){
        val apiinterface= ApiClint().getClient()?.create(ApiInterface::class.java)
        apiinterface?.getDate()?.enqueue(object : Callback<myData?> {
            override fun onResponse(call: Call<myData?>, response: Response<myData?>) {
                val response=response.body()
                for (item in response!!){
                    textV.text = " ${textV.text} \n ${item.name}"
                }
            }

            override fun onFailure(call: Call<myData?>, t: Throwable) {
                call.cancel()
            }
        })

    }
}