package com.fabiano.faoanime.screens.animes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.fabiano.faoanime.R
import com.fabiano.faoanime.databinding.AdapterAnimesBinding
import com.fabiano.faoanime.models.Anime

class AnimesAdapter : PagedListAdapter<Anime, AnimesAdapter.AnimesViewHolder>(diffUtil) {
    private var animes: ArrayList<Anime> = ArrayList()

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
        holder.adapterAnimesBinding.position = position

    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<Anime>() {
            override fun areItemsTheSame(oldItem: Anime, newItem: Anime): Boolean =
                oldItem.malId == newItem.malId

            override fun areContentsTheSame(oldItem: Anime, newItem: Anime): Boolean =
                oldItem == newItem
        }
    }
}



