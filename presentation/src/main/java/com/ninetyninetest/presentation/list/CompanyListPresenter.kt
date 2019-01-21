package com.ninetyninetest.presentation.list

import com.ninetyninetest.data.usecase.GetCompaniesListUseCase
import com.ninetyninetest.presentation.base.BasePresenter


/**
 * Presenter for displaying companies list
 */
class CompanyListPresenter(view: CompanyListView, private val getCompaniesListUseCase: GetCompaniesListUseCase)
    : BasePresenter<CompanyListView>(view) {


    override fun onViewResumed() {
        super.onViewResumed()
        updateCompanies()
    }


    /**
     * Refresh company list
     */
    fun onRefresh() {
        updateCompanies()
    }


    /**
     * Open company details
     * @param companyId Id of the company
     */
    fun onCompanyClicked(companyId: Int) {
        view?.openCompanyDetail(companyId)
    }

    /**
     * Update companies list
     */
    private fun updateCompanies() {
        view?.showLoading(true)

        getCompaniesListUseCase.getCompaniesList {
            view?.run {
                showLoading(false)
                if (it.success && it.body != null) {
                    showCompanies(it.body!!)
                } else {
                    handleError(it.errorMessage)
                }
            }
        }
    }
}