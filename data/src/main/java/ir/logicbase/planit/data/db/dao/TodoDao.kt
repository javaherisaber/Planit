package ir.logicbase.planit.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Maybe
import io.reactivex.Single
import ir.logicbase.planit.data.entity.TodoData

@Dao
interface TodoDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(todo: TodoData)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(todos: List<TodoData>): Completable

    @Query("SELECT * FROM todo WHERE _id=:todoId")
    fun get(todoId: Int): Maybe<TodoData>

    @Query("SELECT * FROM todo")
    fun getTodayTodos(): Maybe<List<TodoData>>
}