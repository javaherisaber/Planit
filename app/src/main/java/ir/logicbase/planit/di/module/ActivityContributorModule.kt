package ir.logicbase.planit.di.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.logicbase.planit.ui.main.MainActivity
import ir.logicbase.planit.ui.main.MainActivityModule
import ir.logicfan.core.di.scope.PerActivity

@Module
abstract class ActivityContributorModule {

    @PerActivity
    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun mainActivity(): MainActivity
}