package ir.logicbase.planit.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import ir.logicbase.planit.R
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_todo, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        presenter.onStart()
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
