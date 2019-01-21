package com.ninetyninetest.app.util

import java.text.NumberFormat
import java.util.Currency
import java.util.Locale

object Util {


    /**
     * Format amount in dollars and using device format
     * @param amount Amount to format
     */
    fun formatAmount(amount: Double): String {
        return NumberFormat.getCurrencyInstance(Locale.getDefault()).apply {
            currency = Currency.getInstance(Locale.US)
        }.format(amount)
    }

}