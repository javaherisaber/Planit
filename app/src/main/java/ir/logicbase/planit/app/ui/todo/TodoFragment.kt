package ir.logicbase.planit.app.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import ir.logicbase.planit.app.R
import ir.logicbase.planit.app.databinding.FragmentTodoBinding
import ir.logicfan.core.data.network.error.NetworkErrorType
import ir.logicfan.core.ui.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_todo.*
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class TodoFragment : BaseFragment(), TodoContract.View {

    @Inject
    lateinit var presenter: TodoContract.Action
    @Inject
    lateinit var adapter: TodoAdapter
    @Inject
    lateinit var todoViewModel: TodoViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return DataBindingUtil.inflate<FragmentTodoBinding>(inflater, R.layout.fragment_todo, container, false)
            .apply {
                setLifecycleOwner(this@TodoFragment) // when we use LiveData in data binding, this expression is required
                viewModel = todoViewModel
            }.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onStart()
        todoViewModel.allTodos.observe(this, Observer { todoList ->
            todoList?.let { presenter.addTodos(it) }
        })
    }

    override fun displayNewItemsInAdapter() {
        adapter.refreshDataSet()
    }

    override fun initializeAdapter() {
        recyclerView_fragmentTodo_tasks.layoutManager = LinearLayoutManager(context)
        recyclerView_fragmentTodo_tasks.adapter = adapter
    }

    override fun hideProgress() {

    }

    override fun showError(error: NetworkErrorType) {

    }

    override fun showProgress() {

    }
}
