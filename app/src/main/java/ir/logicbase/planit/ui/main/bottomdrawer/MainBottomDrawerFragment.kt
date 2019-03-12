package ir.logicbase.planit.ui.main.bottomdrawer

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import ir.logicbase.planit.R
import kotlinx.android.synthetic.main.fragment_main_bottom_drawer.*
import org.jetbrains.anko.toast

class MainBottomDrawerFragment : BottomSheetDialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_main_bottom_drawer, container, false)
    }

    override fun onStart() {
        super.onStart()
        navigationView_fragmentMainBottomDrawer.setNavigationItemSelectedListener {
            when (it.itemId) {
                R.id.navigation_fragmentMain_bottomDrawer_today -> context?.toast("today")
                R.id.navigation_fragmentMain_bottomDrawer_inbox -> context?.toast("inbox")
                R.id.navigation_fragmentMain_bottomDrawer_upcoming -> context?.toast("upcoming")
            }
            true
        }
    }
}