package ir.logicbase.planit.app.ui.todo

import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ir.logicbase.planit.app.BR
import ir.logicbase.planit.app.R
import ir.logicbase.planit.data.entity.TodoData
import ir.logicfan.core.data.base.AppExecutors
import ir.logicfan.core.di.key.ViewModelKey
import ir.logicfan.core.di.scope.PerFragment
import ir.logicfan.core.ui.recyclerview.adapter.SingleDataAdapter
import ir.logicfan.core.ui.recyclerview.diffutil.SimpleDiffCallback

@Module
abstract class TodoModule {

    @Binds
    @PerFragment
    @IntoMap
    @ViewModelKey(TodoViewModel::class)
    abstract fun todoViewModel(todoViewModel: TodoViewModel): ViewModel

    companion object {

        @Provides
        @PerFragment
        fun favoriteListAdapter(appExecutors: AppExecutors) = SingleDataAdapter(
            appExecutors, R.layout.item_todo, SimpleDiffCallback(TodoData::id), BR.item
        )
    }
}