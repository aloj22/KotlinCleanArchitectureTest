package com.ninetyninetest.app.ui.list

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.ninetyninetest.R
import com.ninetyninetest.app.ui.BaseActivity
import com.ninetyninetest.app.ui.detail.CompanyDetailActivity
import com.ninetyninetest.domain.Company
import com.ninetyninetest.presentation.list.CompanyListPresenter
import com.ninetyninetest.presentation.list.CompanyListView
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.ext.android.inject
import org.koin.android.ext.android.setProperty
import org.koin.core.parameter.parametersOf


/**
 * Activity that displays a list of companies
 */
class MainActivity : BaseActivity(), CompanyListView {


    private val mPresenter: CompanyListPresenter by inject { parametersOf(this) }
    private val mAdapter: CompanyAdapter by lazy {
        CompanyAdapter {
            mPresenter.onCompanyClicked(it)
        }
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        companyRecyclerView.run {
            adapter = mAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        swipeRefresh.setOnRefreshListener {
            mPresenter.onRefresh()
        }
    }


    override fun onResume() {
        super.onResume()
        mPresenter.onViewResumed()
    }


    /**
     * Show or hide loading view
     * @param loading
     */
    override fun showLoading(loading: Boolean) {
        swipeRefresh.isRefreshing = loading
    }

    /**
     * Displays a list of companies
     * @param companies List of @See Company to be displayed
     */
    override fun showCompanies(companies: List<Company>) {
        mAdapter.updateItems(companies)
    }

    /**
     * Opens company details
     * @param companyId Id of the company
     */
    override fun openCompanyDetail(companyId: Int) {
        CompanyDetailActivity.launch(this, companyId)
    }
}
