package ir.logicbase.planit.data.domain.repository

import io.reactivex.Completable
import io.reactivex.Maybe
import ir.logicbase.planit.data.entity.TodoData

interface TodoRepository {
    fun insert(todo: TodoData)
    fun insertAll(todos: List<TodoData>): Completable
    fun getTodo(todoId: Int): Maybe<TodoData>
    fun getTodayTodo(): Maybe<List<TodoData>>
}