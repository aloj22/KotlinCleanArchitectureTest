package com.ninetyninetest.app.data

import android.support.annotation.WorkerThread
import com.ninetyninetest.app.data.network.NinetyNineService
import com.ninetyninetest.data.source.CompanyNetworkSource
import com.ninetyninetest.domain.ApiResponse
import com.ninetyninetest.domain.Company

class CompanyNetworkSourceImpl(private val ninetyNineService: NinetyNineService) : CompanyNetworkSource {


    /**
     * Get company list from server
     * @return @See Company list
     */
    @WorkerThread
    override fun getCompanyList(): ApiResponse<List<Company>> {
        return try {
            val response = ninetyNineService.getCompanies().execute()
            ApiResponse(response.isSuccessful, response.body(), null)
        } catch(e: Exception) {
            ApiResponse(false, null, e.localizedMessage)
        }
    }

    /**
     * Get company detail from server
     * @return @See Company
     */
    @WorkerThread
    override fun getCompany(id: Int): ApiResponse<Company> {
        return try {
            val response = ninetyNineService.getCompanies(id).execute()
            ApiResponse(response.isSuccessful, response.body(), null)
        } catch(e: Exception) {
            ApiResponse(false, null, e.localizedMessage)
        }
    }
}