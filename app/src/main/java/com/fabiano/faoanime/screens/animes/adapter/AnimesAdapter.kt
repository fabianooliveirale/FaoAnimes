package com.fabiano.faoanime.screens.animes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.fabiano.faoanime.R
import com.fabiano.faoanime.databinding.AdapterAnimesBinding
import com.fabiano.faoanime.models.Anime

class AnimesAdapter : RecyclerView.Adapter<AnimesAdapter.AnimesViewHolder>() {
    private lateinit var animes: ArrayList<Anime>

    inner class AnimesViewHolder(
        val adapterAnimesBinding: AdapterAnimesBinding
    ) : RecyclerView.ViewHolder(adapterAnimesBinding.root)

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): AnimesAdapter.AnimesViewHolder {
        val binding = DataBindingUtil.inflate<AdapterAnimesBinding>(
            LayoutInflater.from(parent.context),
            R.layout.adapter_animes,
            parent,
            false
        )
        return AnimesViewHolder(binding)
    }

    override fun getItemCount(): Int = animes.count()

    override fun onBindViewHolder(holder: AnimesAdapter.AnimesViewHolder, position: Int) {
        holder.adapterAnimesBinding.anime = animes[position]
    }

    fun replace(animes: ArrayList<Anime>?) {
        this.animes.clear()
        this.animes = animes ?: arrayListOf()
        notifyDataSetChanged()
    }
}