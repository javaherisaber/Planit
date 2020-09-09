package ir.logicbase.planit.app.ui.todo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ir.logicbase.planit.app.R
import ir.logicbase.planit.app.databinding.FragmentTodoBinding
import ir.logicbase.planit.data.entity.TodoData
import ir.logicfan.core.ui.base.BaseFragment
import ir.logicfan.core.ui.recyclerview.adapter.SingleDataAdapter
import javax.inject.Inject

/**
 * A placeholder fragment containing a simple view.
 */
class TodoFragment : BaseFragment() {

    @Inject
    lateinit var adapter: SingleDataAdapter<TodoData>

    private val viewModel: TodoViewModel by viewModels()

    private lateinit var binding: FragmentTodoBinding

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, saveState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_todo, container, false)
        binding.recyclerViewFragmentTodoTasks.adapter = adapter
        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = viewModel
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.onStart()
    }
}
