package com.ninetyninetest.app.data.network

import com.ninetyninetest.domain.Company
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface NinetyNineService {


    @GET("companies")
    fun getCompanies(): Call<List<Company>>


    @GET("companies/{company_id}")
    fun getCompanies(@Path("company_id") companyId: Int): Call<Company>


}