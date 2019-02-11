package ir.logicbase.planit.di.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import ir.logicbase.planit.di.module.ActivityContributorModule
import ir.logicbase.planit.di.module.AppModule
import ir.logicbase.planit.ui.base.BaseApplication
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AndroidSupportInjectionModule::class,
        AppModule::class,
        ActivityContributorModule::class]
)
interface AppComponent : AndroidInjector<DaggerApplication> {

    fun inject(app: BaseApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }
}