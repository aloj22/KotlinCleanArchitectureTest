package com.ninetyninetest.domain

data class Company(val id: Int, val name: String, val ric: String, val sharePrice: Double,
                   val description: String, val country: String)

data class ApiResponse<T>(val success: Boolean, var body: T?, val errorMessage: String?)
