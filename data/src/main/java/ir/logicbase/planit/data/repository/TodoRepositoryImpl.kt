package ir.logicbase.planit.data.repository

import ir.logicbase.planit.data.db.dao.TodoDao
import ir.logicbase.planit.data.domain.repository.TodoRepository
import ir.logicbase.planit.data.entity.TodoData
import javax.inject.Inject

class TodoRepositoryImpl @Inject constructor(
    private val dao: TodoDao
) : TodoRepository {

    override fun insert(todo: TodoData) {
        dao.insert(todo)
    }

    override fun insertAll(todos: List<TodoData>) = dao.insertAll(todos)

    override fun getTodo(todoId: Int) = dao.get(todoId)

    override fun getTodayTodo() = dao.getTodayTodos()
}