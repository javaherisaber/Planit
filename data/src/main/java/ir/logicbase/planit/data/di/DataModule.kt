package ir.logicbase.planit.data.di

import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.Reusable
import ir.logicbase.planit.data.db.dao.TodoDao
import ir.logicbase.planit.data.repository.TodoRepositoryImpl
import ir.logicbase.planit.data.sharedpreferences.AppSharedPreferences
import ir.logicbase.planit.data.domain.repository.TodoRepository
import ir.logicbase.planit.data.entity.TodoData
import ir.logicfan.core.data.sharedpreferences.BaseSharedPreferences

@Module(includes = [RoomModule::class])
abstract class DataModule {

    @Binds
    @Reusable
    abstract fun baseSharedPreferences(appSharedPreferences: AppSharedPreferences): BaseSharedPreferences

    companion object {
        @Provides
        fun todoRepository(dao: TodoDao): TodoRepository = TodoRepositoryImpl(dao)
    }
}