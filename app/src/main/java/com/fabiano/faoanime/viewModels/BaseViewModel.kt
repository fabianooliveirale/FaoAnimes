package com.fabiano.faoanime.viewModels

import androidx.lifecycle.ViewModel
import com.fabiano.faoanime.interfaces.DrawerInterface

open class BaseViewModel : ViewModel() {
    var drawerInterface: DrawerInterface? = null
    var toolbarTitle = ""
    fun closeDrawer() = drawerInterface?.closeDrawer()
    fun toHome() = drawerInterface?.toHome()
    fun toAnimes() = drawerInterface?.toAnimes()
}