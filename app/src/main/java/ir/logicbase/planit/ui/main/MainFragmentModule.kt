package ir.logicbase.planit.ui.main

import androidx.fragment.app.Fragment
import dagger.Binds
import dagger.Module
import ir.logicfan.core.di.qulifier.ParentFragment
import ir.logicfan.core.di.scope.PerFragment
import ir.logicfan.core.ui.base.BaseFragmentModule

@Module(includes = [BaseFragmentModule::class])
abstract class MainFragmentModule {

    @Binds
    @ParentFragment
    @PerFragment
    abstract fun fragment(mainFragment: MainFragment): Fragment
}