package com.ninetyninetest.data.source

import android.support.annotation.WorkerThread
import com.ninetyninetest.domain.ApiResponse
import com.ninetyninetest.domain.Company


/**
 * Get company info from server
 */
interface CompanyNetworkSource {


    /**
     * Get company list from server
     * @return @See Company list
     */
    @WorkerThread
    fun getCompanyList(): ApiResponse<List<Company>>


    /**
     * Get company detail from server
     * @return @See Company
     */
    @WorkerThread
    fun getCompany(id: Int): ApiResponse<Company>

}