package ir.logicbase.planit.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import ir.logicbase.planit.data.db.dao.TodoDao
import ir.logicbase.planit.data.db.entity.Todo
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@Database(entities = [Todo::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun todoDao(): TodoDao

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null

        fun getDatabase(context: Context, scope: CoroutineScope): AppDatabase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }
            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    AppDatabase::class.java,
                    "AppDatabase"
                ).addCallback(AppDatabaseCallback(scope))
                    .build()
                INSTANCE = instance
                return instance
            }
        }
    }

    private class AppDatabaseCallback(private val scope: CoroutineScope) : RoomDatabase.Callback() {

        override fun onOpen(db: SupportSQLiteDatabase) {
            super.onOpen(db)
            INSTANCE?.let {
                scope.launch(Dispatchers.IO) {
                    populateDatabase(it.todoDao())
                }
            }
        }

        private fun populateDatabase(todoDao: TodoDao) {
            var todo = Todo(title = "Do the groceries", time = "16:30")
            todoDao.insert(todo)
            todo = Todo(title = "Wash your clothes", time = "17:00")
            todoDao.insert(todo)
            todo = Todo(title = "Go to the gym", time = "19:00")
            todoDao.insert(todo)
            todo = Todo(title = "Review your kotlin notes", time = "06:00")
            todoDao.insert(todo)
            todo = Todo(title = "Implement Room database", time = "14:30")
            todoDao.insert(todo)
        }
    }
}