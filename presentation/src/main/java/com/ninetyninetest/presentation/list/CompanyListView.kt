package com.ninetyninetest.presentation.list

import com.ninetyninetest.domain.Company
import com.ninetyninetest.presentation.base.BaseView


/**
 * View for displaying company list
 */
interface CompanyListView : BaseView {


    /**
     * Show or hide loading view
     * @param loading
     */
    fun showLoading(loading: Boolean)


    /**
     * Displays a list of companies
     * @param companies List of @See Company to be displayed
     */
    fun showCompanies(companies: List<Company>)


    /**
     * Opens company details
     * @param companyId Id of the company
     */
    fun openCompanyDetail(companyId: Int)

}