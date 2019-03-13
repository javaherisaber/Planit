package ir.logicbase.planit.data.db.dao

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import ir.logicbase.planit.data.db.entity.Todo

@Dao
interface TodoDao {

    @Insert
    fun insert(todo: Todo)

    @Query("SELECT * FROM todo")
    fun getAllTodos(): LiveData<List<Todo>>
}