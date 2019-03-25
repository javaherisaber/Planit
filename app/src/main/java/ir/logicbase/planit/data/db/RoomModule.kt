package ir.logicbase.planit.data.db

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.logicbase.planit.data.db.dao.TodoDao
import ir.logicfan.core.di.qulifier.ApplicationContext
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun appDatabase(@ApplicationContext context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun todoDao(appDatabase: AppDatabase): TodoDao = appDatabase.todoDao()
}

