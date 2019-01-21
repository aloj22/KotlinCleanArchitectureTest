package com.ninetyninetest.app

import android.app.Application
import com.ninetyninetest.app.di.KoinModules
import org.koin.android.ext.android.startKoin

/**
 * Custom @see Application that injects koin dependencies
 */
class NinetyNineApplication : Application() {


    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(KoinModules.MODULES))
    }

}