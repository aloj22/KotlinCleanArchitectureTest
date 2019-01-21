package com.ninetyninetest.data.repository

import com.ninetyninetest.data.source.CompanyNetworkSource
import com.ninetyninetest.domain.ApiResponse
import com.ninetyninetest.domain.Company


/**
 * Companies repository
 */
class CompaniesRepository(private val companyNetworkSource: CompanyNetworkSource) {


    /**
     * Get company list
     * @return @See Company list
     */
    fun getCompaniesList(): ApiResponse<List<Company>> = companyNetworkSource.getCompanyList()

    /**
     * Get company detail
     * @return @See Company
     */
    fun getCompany(id: Int): ApiResponse<Company> = companyNetworkSource.getCompany(id)

}