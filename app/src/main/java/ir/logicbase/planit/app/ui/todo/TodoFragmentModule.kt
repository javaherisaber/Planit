package ir.logicbase.planit.app.ui.todo

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.multibindings.IntoMap
import ir.logicbase.planit.app.di.key.ViewModelKey
import ir.logicfan.core.di.qulifier.ParentFragment
import ir.logicfan.core.di.scope.PerFragment
import ir.logicfan.core.ui.base.BaseFragmentModule

@Module(includes = [BaseFragmentModule::class])
abstract class TodoFragmentModule {

    @Binds
    @ParentFragment
    @PerFragment
    abstract fun fragment(todoFragment: TodoFragment): Fragment

    @Binds
    @PerFragment
    abstract fun adapterAction(presenter: TodoPresenter): TodoContract.AdapterAction

    @Binds
    @PerFragment
    abstract fun action(presenter: TodoPresenter): TodoContract.Action

    @Binds
    @PerFragment
    abstract fun view(fragment: TodoFragment): TodoContract.View

    @Module
    companion object {
        @Provides
        @PerFragment
        @IntoMap
        @ViewModelKey(TodoViewModel::class)
        @JvmStatic
        fun todoViewModel(fragment: TodoFragment, viewModelFactory: ViewModelProvider.Factory): TodoViewModel {
            return ViewModelProviders.of(fragment, viewModelFactory).get(TodoViewModel::class.java)
        }
    }
}