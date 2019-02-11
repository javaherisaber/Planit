package ir.logicbase.planit.ui.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.logicfan.core.di.scope.PerActivity
import ir.logicfan.core.di.scope.PerFragment
import ir.logicfan.core.ui.base.BaseActivityModule

@Module(includes = [BaseActivityModule::class])
abstract class MainActivityModule {

    @Binds
    @PerActivity
    abstract fun activity(mainActivity: MainActivity): Activity

    @Binds
    @PerActivity
    abstract fun appCompatActivity(mainActivity: MainActivity): AppCompatActivity

    @PerFragment
    @ContributesAndroidInjector(modules = [MainFragmentModule::class])
    abstract fun mainFragment(): MainFragment
}