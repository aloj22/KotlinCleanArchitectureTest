package com.ninetyninetest.presentation.detail

import com.ninetyninetest.data.usecase.GetCompanyUseCase
import com.ninetyninetest.presentation.base.BasePresenter
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


/**
 * Displays company details, data is refreshed every @see UPDATE_SECONDS seconds
 * @param getCompanyUseCase Use case to get company details
 */
class CompanyDetailPresenter(view: CompanyDetailView, private val getCompanyUseCase: GetCompanyUseCase)
    : BasePresenter<CompanyDetailView>(view) {


    companion object {
        private const val UPDATE_SECONDS = 20L
    }


    private var mCompanyId = -1
    private val mScheduler = Executors.newScheduledThreadPool(1)
    private val mRunnable = Runnable {
        updateCompanyInfo(true)
        scheduleUpdate()
    }


    /**
     * Bind company info
     * @param companyId Id of the company
     */
    fun onViewCreated(companyId: Int) {
        this.mCompanyId = companyId
        updateCompanyInfo(false)
        scheduleUpdate()
    }

    /**
     * Update company info
     */
    private fun updateCompanyInfo(fromRefresh: Boolean) {
        getCompanyUseCase.getCompany(mCompanyId) {
            view?.run {
                if (it.success && it.body != null) {
                    val company = it.body!!
                    showName(company.name)
                    showRIC(company.ric)
                    showCountry(company.country)
                    showDescription(company.description)
                    showSharePrice(company.sharePrice, fromRefresh)
                } else {
                    handleError(it.errorMessage)
                }
            }
        }
    }

    override fun onViewDestroyed() {
        super.onViewDestroyed()
        mScheduler.shutdownNow()
    }

    /**
     * Schedule next info update
     */
    private fun scheduleUpdate() {
        mScheduler.schedule(mRunnable, UPDATE_SECONDS, TimeUnit.SECONDS)
    }

}