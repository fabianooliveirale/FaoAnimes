package com.fabiano.faoanime.screens.animes

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log.d
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.Toolbar
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.fabiano.faoanime.R
import com.fabiano.faoanime.bases.BaseDrawerFragment
import com.fabiano.faoanime.databinding.FragmentAnimesBinding
import com.fabiano.faoanime.interfaces.ResponseInterface
import com.fabiano.faoanime.models.responses.SearchReponse
import com.fabiano.faoanime.screens.animes.adapter.AnimesAdapter
import com.fabiano.faoanime.utils.KeyboardUtils
import com.fabiano.faoanime.utils.ViewAnimation
import com.fabiano.faoanime.utils.extensions.*
import kotlinx.android.synthetic.main.fragment_animes.*


class AnimesFragment : BaseDrawerFragment(), Toolbar.OnMenuItemClickListener, ResponseInterface {

    lateinit var animesViewModel: AnimesViewModel
    lateinit var fragmentHomeBinding: FragmentAnimesBinding
    var adapter: AnimesAdapter? = null
    private val animation = ViewAnimation()
    private var searchHeight = 0
    private var isCollapse = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        fragmentHomeBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_animes, container, false)
        initViewModel()
        initToolbar()
        initNavigation()

        return fragmentHomeBinding.root
    }

    @SuppressLint("RestrictedApi")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initInputText()
        initAnimation()
        initRecyclerView()
        liveData()
    }

    private fun liveData() {
        animesViewModel.animesLiveData.observe(viewLifecycleOwner, Observer { animes ->
            adapter?.replace(animes)
        })

        animesViewModel.searchLiveData.observe(viewLifecycleOwner, Observer { searchItem ->
            isCollapse = !isCollapse
            searchItem?.icon = animesViewModel.getSearchIcon(isCollapse)
            animateSearch()
        })
    }

    private fun initRecyclerView() {
        adapter = AnimesAdapter()
        recyclerView.initTwoGridLayout(adapter)
    }

    private fun initAnimation() {
        searchHeight = constraintSearch.layoutParams.height
        animation.fadeInDown(toolbarInclude)
    }

    private fun initToolbar() {
        setHasOptionsMenu(true)
        animesViewModel.toolbarTitle = getString(R.string.animes)
        fragmentHomeBinding.toolbarInclude.viewModel = animesViewModel
        fragmentHomeBinding.toolbarInclude.toolbar.inflateMenu(R.menu.toolbar_menu)
        fragmentHomeBinding.toolbarInclude.toolbar.setOnMenuItemClickListener(this)
    }

    private fun initInputText() {
        editTextSearch.onTextChanged(animesViewModel.textchanger)
    }

    private fun initNavigation() {
        navController = view?.findNavController()
    }

    private fun initViewModel() {
        animesViewModel = ViewModelProvider(this).get(AnimesViewModel::class.java)
        animesViewModel.drawerInterface = this
        animesViewModel.responseInterface = this
        fragmentHomeBinding.viewModel = animesViewModel
        fragmentHomeBinding.navigationInclude.viewModel = animesViewModel
    }

    override fun onMenuItemClick(item: MenuItem): Boolean {
        val id: Int = item.itemId
        if (id == R.id.action_search) {
            if (animation.inAnimation) return false
            animesViewModel.searchLiveData.value = item
            return true
        }
        return false
    }

    private fun animateSearch() {
        if (isCollapse) {
            animation.decreaseViewSize(constraintSearch, 70, duration = 450) {
                editTextSearch.clearFocus()
                KeyboardUtils.forceCloseKeyboard(editTextSearch)
            }
        } else {
            animation.increaseViewSize(constraintSearch, 70, duration = 450) {
                editTextSearch.requestFocus()
                KeyboardUtils.toggleKeyboardVisibility(activity)
            }
        }
    }

    override fun <T> success(response: T) {
        (response as SearchReponse)
        val animes = response.results
        adapter?.replace(animes)
    }

    override fun error(error: String) {
        activity?.toast(error)
    }
}
