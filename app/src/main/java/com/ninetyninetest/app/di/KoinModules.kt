package com.ninetyninetest.app.di

import com.ninetyninetest.R
import com.ninetyninetest.app.data.CompanyNetworkSourceImpl
import com.ninetyninetest.app.data.network.WebService
import com.ninetyninetest.data.repository.CompaniesRepository
import com.ninetyninetest.data.source.CompanyNetworkSource
import com.ninetyninetest.data.usecase.GetCompaniesListUseCase
import com.ninetyninetest.data.usecase.GetCompanyUseCase
import com.ninetyninetest.presentation.detail.CompanyDetailPresenter
import com.ninetyninetest.presentation.detail.CompanyDetailView
import com.ninetyninetest.presentation.list.CompanyListPresenter
import com.ninetyninetest.presentation.list.CompanyListView
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module.module

object KoinModules {

    /**
     * Koin modules definition
     */
    val MODULES = module {
        single { WebService.getService(androidContext().getString(R.string.server_url)) }
        factory { CompanyNetworkSourceImpl(get()) as CompanyNetworkSource }
        factory { CompaniesRepository(get()) }
        factory { GetCompanyUseCase(get()) }
        factory { GetCompaniesListUseCase(get()) }
        factory { (view: CompanyDetailView) -> CompanyDetailPresenter(view, get()) }
        factory { (view: CompanyListView) -> CompanyListPresenter(view, get()) }
    }


}