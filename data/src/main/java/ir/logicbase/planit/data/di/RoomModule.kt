package ir.logicbase.planit.data.di

import android.content.Context
import androidx.room.Room
import dagger.Module
import dagger.Provides
import ir.logicbase.planit.data.db.AppDatabase
import ir.logicbase.planit.data.db.DATABASE_NAME
import ir.logicbase.planit.data.db.dao.TodoDao
import javax.inject.Singleton

@Module
class RoomModule {

    @Provides
    @Singleton
    fun appDatabase(context: Context): AppDatabase {
        return Room.databaseBuilder(
            context,
            AppDatabase::class.java,
            DATABASE_NAME
        ).build()
    }

    @Provides
    fun todoDao(appDatabase: AppDatabase): TodoDao = appDatabase.todoDao()
}

