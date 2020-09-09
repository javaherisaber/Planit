package ir.logicbase.planit.app.ui.todo

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.observers.DisposableCompletableObserver
import io.reactivex.observers.DisposableMaybeObserver
import io.reactivex.observers.DisposableSingleObserver
import io.reactivex.schedulers.Schedulers
import ir.logicbase.planit.data.domain.repository.TodoRepository
import ir.logicbase.planit.data.entity.TodoData
import ir.logicfan.core.ui.base.BaseViewModel
import org.jetbrains.anko.Android
import javax.inject.Inject

class TodoViewModel @Inject constructor(
    private val todoRepository: TodoRepository,
    compositeDisposable: CompositeDisposable
) : BaseViewModel(compositeDisposable) {

    private val _data = MutableLiveData<List<TodoData>>()
    val data: LiveData<List<TodoData>> = _data

    fun onStart() {
        insertDummy()
    }

    private fun insertDummy() {
        val todos = arrayListOf(
            TodoData(1, title = "Do the groceries", time = "16:30"),
            TodoData(2, title = "Wash your clothes", time = "17:00"),
            TodoData(3, title = "Go to the gym", time = "19:00"),
            TodoData(4, title = "Review your kotlin notes", time = "06:00"),
            TodoData(5, title = "Implement Room database", time = "14:30"))
        disposableContext {
            todoRepository.insertAll(todos)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(object : DisposableCompletableObserver() {
                    override fun onComplete() {
                        loadTodos()
                    }

                    override fun onError(e: Throwable) {
                    }
                })
        }
    }

    private fun loadTodos() = disposableContext {
        todoRepository.getTodayTodo()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribeWith(object : DisposableMaybeObserver<List<TodoData>>() {
                override fun onSuccess(data: List<TodoData>) {
                    _data.value = data
                }

                override fun onError(e: Throwable) {}

                override fun onComplete() {}
            })
    }

    val title = "Today"
}