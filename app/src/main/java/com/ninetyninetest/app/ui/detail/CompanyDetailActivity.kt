package com.ninetyninetest.app.ui.detail

import android.animation.Animator
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.MenuItem
import com.ninetyninetest.R
import com.ninetyninetest.app.ui.BaseActivity
import com.ninetyninetest.app.util.Util
import com.ninetyninetest.presentation.detail.CompanyDetailPresenter
import com.ninetyninetest.presentation.detail.CompanyDetailView
import kotlinx.android.synthetic.main.activity_company_detail.*
import org.koin.android.ext.android.inject
import org.koin.core.parameter.parametersOf


/**
 * Activity that displays @see Company details
 */
class CompanyDetailActivity : BaseActivity(), CompanyDetailView {


    companion object {

        private const val COMPANY_ID = "company_id"


        /**
         * Launches @see CompanyDetailActivity
         * @param context
         * @param companyId Id of the company to be displayed
         */
        fun launch(context: Context, companyId: Int) {
            context.startActivity(Intent(context, CompanyDetailActivity::class.java).apply {
                putExtra(COMPANY_ID, companyId)
            })
        }
    }


    private val mPresenter: CompanyDetailPresenter by inject { parametersOf(this) }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_company_detail)

        mPresenter.onViewCreated(intent.getIntExtra(COMPANY_ID, -1))

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onOptionsItemSelected(item: MenuItem?) = when (item?.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> super.onOptionsItemSelected(item)
    }

    /**
     * Display company name
     * @param name Name of the company
     */
    override fun showName(name: String) {
        companyName.text = name
    }

    /**
     * Display company share price
     * @param sharePrice Share price of the company
     * @param animate Animate share price or not
     */
    override fun showSharePrice(sharePrice: Double, animate: Boolean) {
        if (animate) {
            companySharePrice.animate().alpha(0f).setListener(object : AnimatorListenerAdapter() {
                override fun onAnimationEnd(animation: Animator?) {
                    companySharePrice.run {
                        text = Util.formatAmount(sharePrice)
                        animate().alpha(1f).start()
                    }
                }
            }).start()
        } else {
            companySharePrice.text = Util.formatAmount(sharePrice)
        }
    }

    /**
     * Display company RIC
     * @param RIC RIC of the company
     */
    override fun showRIC(RIC: String) {
        companyRIC.text = RIC
        supportActionBar?.title = RIC
    }

    /**
     * Display company description
     * @param description Description of the company
     */
    override fun showDescription(description: String) {
        companyDescription.text = description
    }

    /**
     * Display company country
     * @param country Country of the company
     */
    override fun showCountry(country: String) {
        companyCountry.text = country
    }
}
