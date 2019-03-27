package ir.logicbase.planit.app.ui.main

import android.app.Activity
import androidx.appcompat.app.AppCompatActivity
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import ir.logicbase.planit.app.ui.main.bottomdrawer.MainBottomDrawerFragment
import ir.logicbase.planit.app.ui.main.bottomdrawer.MainBottomDrawerModule
import ir.logicbase.planit.app.ui.todo.TodoFragment
import ir.logicbase.planit.app.ui.todo.TodoFragmentModule
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
    @ContributesAndroidInjector(modules = [TodoFragmentModule::class])
    abstract fun todoFragment(): TodoFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [MainBottomDrawerModule::class])
    abstract fun mainBottomDrawerFragment(): MainBottomDrawerFragment
}