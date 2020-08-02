package com.fabiano.faoanime.bases

import android.view.View
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.fabiano.faoanime.R
import com.fabiano.faoanime.interfaces.DrawerInterface
import com.fabiano.faoanime.utils.KeyboardUtils
import kotlinx.android.synthetic.main.app_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.drawerLayout

open class BaseDrawerFragment : Fragment(), DrawerInterface {

    var navController: NavController? = null
    var viewFocus: View? = null
    var needFocus = false

    override fun onStart() {
        super.onStart()
        setDrawer()
    }

    private fun setDrawer() {
        activity?.let { activity ->
            val drawerToggle: ActionBarDrawerToggle = object : ActionBarDrawerToggle(
                activity,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
            ) {
                override fun onDrawerClosed(view: View) {
                    super.onDrawerClosed(view)
                    if (needFocus) {
                        viewFocus?.requestFocus()
                        KeyboardUtils.toggleKeyboardVisibility(activity)
                    }
                }

                override fun onDrawerOpened(drawerView: View) {
                    super.onDrawerOpened(drawerView)
                    viewFocus?.let {
                        viewFocus?.clearFocus()
                        KeyboardUtils.forceCloseKeyboard(viewFocus)
                    }
                }
            }

            drawerToggle.isDrawerIndicatorEnabled = true
            drawerToggle.drawerArrowDrawable.color = activity.getColor(R.color.colorAccent)
            drawerLayout.addDrawerListener(drawerToggle)
            drawerToggle.syncState()
        }
    }

    override fun closeDrawer() = drawerLayout.closeDrawer(GravityCompat.START)
    override fun toHome() = view?.findNavController()?.navigate(R.id.homeFragment)
    override fun toAnimes() = view?.findNavController()?.navigate(R.id.animesFragment)
}