package ir.logicbase.planit.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.logicbase.planit.R
import ir.logicfan.core.ui.base.BaseFragment

/**
 * A placeholder fragment containing a simple view.
 */
class MainFragment : BaseFragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_main, container, false)
    }
}
