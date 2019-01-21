package com.ninetyninetest.data.usecase

import com.ninetyninetest.data.repository.CompaniesRepository
import com.ninetyninetest.domain.ApiResponse
import com.ninetyninetest.domain.Company
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Get a company
 * @param companiesRepository Repository to take company from
 */
class GetCompanyUseCase(private val companiesRepository: CompaniesRepository) {


    /**
     * Get a company
     * @param companyId Id of the company
     * @param listener Listener that will be called the company is retrieved
     */
    fun getCompany(companyId: Int, listener: (ApiResponse<Company>) -> Unit) {

        GlobalScope.launch(Dispatchers.Main) {

            val company = withContext(Dispatchers.Default) {
                companiesRepository.getCompany(companyId)
            }

            listener.invoke(company)

        }

    }

}