package com.ninetyninetest.data.usecase

import com.ninetyninetest.data.repository.CompaniesRepository
import com.ninetyninetest.domain.ApiResponse
import com.ninetyninetest.domain.Company
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext


/**
 * Get a list of companies
 * @param companiesRepository Repository to take companies from
 */
class GetCompaniesListUseCase(private val companiesRepository: CompaniesRepository) {


    /**
     * Get a list of companies order by its share price
     * @param listener Called when company list is retrieved
     */
    fun getCompaniesList(listener: (ApiResponse<List<Company>>) -> Unit) {

        GlobalScope.launch(Dispatchers.Main) {

            val list = withContext(Dispatchers.Default) {
                companiesRepository.getCompaniesList().apply {
                    body = body?.sortedBy { it.sharePrice }
                }
            }

            listener.invoke(list)

        }

    }

}