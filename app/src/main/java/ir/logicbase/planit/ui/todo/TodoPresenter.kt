package ir.logicbase.planit.ui.todo

import ir.logicbase.planit.ui.model.Time
import ir.logicbase.planit.ui.model.Todo
import javax.inject.Inject

class TodoPresenter @Inject
constructor(private val view: TodoContract.View) : TodoContract.Action, TodoContract.AdapterAction {

    private var todoList: List<Todo> = listOf()

    override fun onStart() {
        todoList = listOf(
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30)),
            Todo(false, "طراحی رابط کاربری پلنیت", Time(16, 30))
        )
        view.initializeAdapter()
    }

    override fun onStop() {

    }

    override fun getTodo(position: Int): Todo = todoList[position]

    override fun getTodoItemCount(): Int = todoList.size
}