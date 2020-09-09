package ir.logicbase.planit.app.di

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import ir.logicbase.planit.app.base.BaseApplication
import ir.logicbase.planit.data.di.DataModule
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        AppModule::class,
        DataModule::class,
        AndroidSupportInjectionModule::class,
        ActivityBindingModule::class]
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