package ir.logicbase.planit.app.ui.main

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.android.ContributesAndroidInjector
import dagger.multibindings.IntoMap
import ir.logicbase.planit.app.ui.main.bottomdrawer.MainBottomDrawerFragment
import ir.logicbase.planit.app.ui.main.bottomdrawer.MainBottomDrawerModule
import ir.logicbase.planit.app.ui.todo.TodoFragment
import ir.logicbase.planit.app.ui.todo.TodoModule
import ir.logicfan.core.di.key.ViewModelKey
import ir.logicfan.core.di.scope.PerActivity
import ir.logicfan.core.di.scope.PerFragment
import ir.logicfan.core.ui.feature.main.NetworkConnectivityViewModel

@Module
abstract class MainModule {

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel

    @Binds
    @PerActivity
    @IntoMap
    @ViewModelKey(NetworkConnectivityViewModel::class)
    abstract fun networkConnectivityViewModel(networkConnectivityViewModel: NetworkConnectivityViewModel): ViewModel

    @PerFragment
    @ContributesAndroidInjector(modules = [TodoModule::class])
    abstract fun todoFragment(): TodoFragment

    @PerFragment
    @ContributesAndroidInjector(modules = [MainBottomDrawerModule::class])
    abstract fun mainBottomDrawerFragment(): MainBottomDrawerFragment
}