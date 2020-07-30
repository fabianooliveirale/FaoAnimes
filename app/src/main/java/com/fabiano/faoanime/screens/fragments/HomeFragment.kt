package com.fabiano.faoanime.screens.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import com.fabiano.faoanime.R
import com.fabiano.faoanime.databinding.FragmentHomeBinding
import com.fabiano.faoanime.viewModels.HomeViewModel
import kotlinx.android.synthetic.main.app_toolbar.*
import kotlinx.android.synthetic.main.app_toolbar.view.*

class HomeFragment : BaseDrawerFragment() {

    lateinit var homeViewModel: HomeViewModel
    lateinit var fragmentHomeBinding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)
        initViewModel()
        initNavigation()
        return fragmentHomeBinding.root
    }

    private fun initNavigation() {
        navController = view?.findNavController()
    }

    private fun initViewModel() {
        homeViewModel = ViewModelProvider(this).get(HomeViewModel::class.java)
        homeViewModel.drawerInterface = this
        homeViewModel.toolbarTitle = getString(R.string.home)
        fragmentHomeBinding.viewModel = homeViewModel
        fragmentHomeBinding.navigationInclude.viewModel = homeViewModel
        fragmentHomeBinding.toolbarInclude.viewModel = homeViewModel
    }

}
