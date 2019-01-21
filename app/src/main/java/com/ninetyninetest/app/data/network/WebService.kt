package com.ninetyninetest.app.data.network

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object WebService {



    private lateinit var service: NinetyNineService


    fun getService(baseUrl: String): NinetyNineService {

        if (!::service.isInitialized) {
            service = Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .client(OkHttpClient().newBuilder().build())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
                    .create(NinetyNineService::class.java)
        }

        return service
    }

}