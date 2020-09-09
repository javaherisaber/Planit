package ir.logicbase.planit.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import ir.logicbase.planit.data.db.dao.TodoDao
import ir.logicbase.planit.data.entity.TodoData

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "AppDatabase"

@Database(entities = [TodoData::class], version = DATABASE_VERSION, exportSchema = true)
abstract class AppDatabase : RoomDatabase() {

    abstract fun todoDao(): TodoDao
}