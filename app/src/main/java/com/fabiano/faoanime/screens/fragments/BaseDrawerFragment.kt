package com.fabiano.faoanime.screens.fragments

import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.fabiano.faoanime.R
import com.fabiano.faoanime.interfaces.DrawerInterface
import kotlinx.android.synthetic.main.app_toolbar.*
import kotlinx.android.synthetic.main.fragment_home.*

open class BaseDrawerFragment : Fragment(), DrawerInterface {

    var navController: NavController? = null

    override fun onStart() {
        super.onStart()
        setDrawer()
    }

    private fun setDrawer() {
        activity?.let { activity ->
            val drawerToggle = ActionBarDrawerToggle(
                activity,
                drawerLayout,
                toolbar,
                R.string.drawer_open,
                R.string.drawer_close
            )

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