package com.ninetyninetest.presentation.detail

import com.ninetyninetest.presentation.base.BaseView


/**
 * View for displaying company details
 */
interface CompanyDetailView : BaseView {


    /**
     * Display company name
     * @param name Name of the company
     */
    fun showName(name: String)

    /**
     * Display company share price
     * @param sharePrice Share price of the company
     * @param animate Animate share price or not
     */
    fun showSharePrice(sharePrice: Double, animate: Boolean)

    /**
     * Display company RIC
     * @param ric RIC of the company
     */
    fun showRIC(RIC: String)

    /**
     * Display company description
     * @param description Description of the company
     */
    fun showDescription(description: String)

    /**
     * Display company country
     * @param country Country of the company
     */
    fun showCountry(country: String)


}