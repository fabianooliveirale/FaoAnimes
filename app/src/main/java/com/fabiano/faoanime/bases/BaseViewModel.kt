package com.fabiano.faoanime.bases

import androidx.lifecycle.ViewModel
import com.fabiano.faoanime.interfaces.DrawerInterface
import com.fabiano.faoanime.interfaces.ResponseInterface

open class BaseViewModel : ViewModel() {
    var drawerInterface: DrawerInterface? = null
    var responseInterface: ResponseInterface? = null
    var toolbarTitle = ""
    fun closeDrawer() = drawerInterface?.closeDrawer()
    fun toHome() = drawerInterface?.toHome()
    fun toAnimes() = drawerInterface?.toAnimes()
}