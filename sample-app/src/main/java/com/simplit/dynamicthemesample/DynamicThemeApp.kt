package com.simplit.dynamicthemesample

import android.app.Application
import com.simplit.dynamicthemesample.di.AppCompositionRoot

class DynamicThemeApp : Application() {
    lateinit var compositionRoot : AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = AppCompositionRoot(applicationContext)
    }
}