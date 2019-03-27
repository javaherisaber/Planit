package ir.logicbase.planit.app.di.module

import androidx.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.Module
import ir.logicbase.planit.app.data.db.RoomModule
import ir.logicbase.planit.app.ui.base.BaseViewModelFactory
import ir.logicfan.core.di.module.BaseModule

@Module(includes = [BaseModule::class, RoomModule::class])
abstract class AppModule {

    @Binds
    abstract fun baseViewModelFactory(viewModelFactory: BaseViewModelFactory): ViewModelProvider.Factory
}