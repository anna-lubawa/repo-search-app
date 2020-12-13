package com.annalubawa.reposearchapp.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.annalubawa.reposearchapp.R
import com.annalubawa.reposearchapp.databinding.ListItemLayoutBinding
import com.annalubawa.reposearchapp.domain.model.Repository

class RepositoriesRecyclerViewAdapter (
    private val items: List<Repository>,
    private val onItemSelected: (item: Repository) -> Unit
): RecyclerView.Adapter<RepositoriesRecyclerViewAdapter.RepositoriesViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        RepositoriesViewHolder(
            DataBindingUtil.inflate<ListItemLayoutBinding>(
                LayoutInflater.from(parent.context),
                R.layout.list_item_layout,
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: RepositoriesViewHolder, position: Int) {
        holder.repoContainerBinding.repo = items[position]
        holder.repoContainerBinding.root.setOnClickListener {
            onItemSelected(items[position])
        }
    }

    override fun getItemCount(): Int  = items.size

    inner class RepositoriesViewHolder(val repoContainerBinding: ListItemLayoutBinding)
        : RecyclerView.ViewHolder(repoContainerBinding.root)
}