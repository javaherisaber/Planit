package ir.logicbase.planit.app.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.logicbase.planit.app.data.db.dao.TodoDao
import ir.logicbase.planit.app.data.db.entity.Todo

internal const val DATABASE_VERSION = 1
internal const val DATABASE_NAME = "AppDatabase"

@Database(entities = [Todo::class], version = DATABASE_VERSION)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao

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