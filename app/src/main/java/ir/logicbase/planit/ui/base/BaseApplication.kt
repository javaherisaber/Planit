package ir.logicbase.planit.ui.base

import android.content.Context
import android.content.res.Configuration
import androidx.multidex.MultiDex
import com.crashlytics.android.Crashlytics
import com.crashlytics.android.core.CrashlyticsCore
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import io.fabric.sdk.android.Fabric
import ir.logicbase.planit.BuildConfig
import ir.logicbase.planit.di.component.DaggerAppComponent
import ir.logicfan.core.data.pref.BasePrefManager
import ir.logicfan.core.util.LocaleManager
import javax.inject.Inject

class BaseApplication : DaggerApplication() {

    @Inject
    lateinit var prefManager: BasePrefManager

    override fun onCreate() {
        super.onCreate()
        // Set up Crashlytics, disabled for debug builds
        val crashlyticsKit: Crashlytics? = Crashlytics.Builder()
            .core(CrashlyticsCore.Builder().disabled(BuildConfig.DEBUG).build())
            .build()
        // Initialize Fabric with the debug-disabled crashlytics.
        Fabric.with(this, crashlyticsKit)
    }

    override fun attachBaseContext(base: Context?) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val appComponent = DaggerAppComponent.builder().application(this).build()
        appComponent.inject(this)
        return appComponent
    }

    override fun onConfigurationChanged(newConfig: Configuration?) {
        super.onConfigurationChanged(newConfig)
        LocaleManager.setLocale(this, prefManager.settingsPrefLangList)
    }

}