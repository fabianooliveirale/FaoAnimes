package com.fabiano.faoanime.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.fabiano.faoanime.R
import com.fabiano.faoanime.databinding.FragmentAnimesBinding
import com.fabiano.faoanime.viewModels.AnimesViewModel
import kotlinx.android.synthetic.main.app_toolbar.*

class AnimesFragment : BaseDrawerFragment() {

    lateinit var animesViewModel: AnimesViewModel
    lateinit var fragmentHomeBinding: FragmentAnimesBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_animes, container, false)
        initViewModel()
        return fragmentHomeBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initNavigation()
        initToolbar()
    }

    private fun initNavigation() {
        navController = view?.findNavController()
    }

    private fun initViewModel() {
        animesViewModel = ViewModelProvider(this).get(AnimesViewModel::class.java)
        animesViewModel.drawerInterface = this
        animesViewModel.toolbarTitle = getString(R.string.animes)
        fragmentHomeBinding.viewModel = animesViewModel
        fragmentHomeBinding.toolbarInclude.viewModel = animesViewModel
        fragmentHomeBinding.navigationInclude.viewModel = animesViewModel
    }

    private fun initToolbar() {
        navController?.let {
            toolbar.setTitle(R.string.animes)
            NavigationUI.setupWithNavController(toolbar, it)
        }
    }
}
