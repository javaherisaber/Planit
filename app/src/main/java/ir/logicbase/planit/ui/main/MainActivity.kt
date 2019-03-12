package ir.logicbase.planit.ui.main

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import co.ronash.pushe.Pushe
import ir.logicbase.planit.R
import ir.logicbase.planit.ui.main.bottomdrawer.MainBottomDrawerFragment
import ir.logicfan.core.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast

class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setTheme(R.style.AppTheme)
        setContentView(R.layout.activity_main)
        Pushe.initialize(this, true)
        setSupportActionBar(bottomAppBar_activityMain)

        fab_activityMain.setOnClickListener {
            toast("clicked on fab")
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.activity_main_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            android.R.id.home -> {
                val bottomDrawerFragment = MainBottomDrawerFragment()
                bottomDrawerFragment.show(supportFragmentManager, bottomDrawerFragment.tag)
                true
            }
            R.id.menu_activityMain_settings -> {
                toast("clicked on settings")
                true
            }
            R.id.menu_activityMain_search -> {
                toast("clicked on Search")
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }
}
