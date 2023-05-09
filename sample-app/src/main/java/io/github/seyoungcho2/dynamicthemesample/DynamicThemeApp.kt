package io.github.seyoungcho2.dynamicthemesample

import android.app.Application
import io.github.seyoungcho2.dynamicthemesample.di.AppCompositionRoot

class DynamicThemeApp : Application() {
    lateinit var compositionRoot : AppCompositionRoot

    override fun onCreate() {
        super.onCreate()
        compositionRoot = AppCompositionRoot(applicationContext)
    }
}