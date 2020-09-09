package ir.logicbase.planit.app.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.logicbase.planit.app.ui.main.MainActivity
import ir.logicbase.planit.app.ui.main.MainModule
import ir.logicfan.core.di.scope.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainModule::class])
    abstract fun mainActivity(): MainActivity
}