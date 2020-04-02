package com.joshualorett.heterogeneousrecyclerviewadapter

import androidx.collection.SparseArrayCompat
import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup
import kotlin.IllegalArgumentException

/**
 * This adapter will trigger ViewHolder creation and binding via its ViewHolderCreators and
 * ViewHolderBinders respectively.
 *
 * There only needs to be a single ViewHolderCreator for each type of layout supported.
 * The number of ViewHolderBinders should be in parity with the data set.
 *
 * Created by Joshua on 11/20/2016.
 */

class HeterogeneousRecyclerViewAdapter(viewHolderCreators: List<ViewHolderCreator> = emptyList()) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /***
     * Get the data for your list. The ViewHolderBinders that bind data to your ViewHolders.
     */
    var binders: List<ViewHolderBinder<Any>> = emptyList()

    private var creators: SparseArrayCompat<ViewHolderCreator> = SparseArrayCompat(viewHolderCreators.size)

    init {
        viewHolderCreators.forEach { creator -> creators.put(creator.viewType, creator) }
    }

    fun addCreator(creator: ViewHolderCreator) {
        if(creators.containsKey(creator.viewType)) {
            throw IllegalArgumentException("A creator of type ${creator.viewType} already exists.")
        }
        creators.put(creator.viewType, creator)
    }

    fun removeCreatorByViewType(viewType: Int) {
        creators.remove(viewType)
    }

    /***
     * @throws IllegalArgumentException if a ViewHolderCreator was not found.
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val creator = creators.get(viewType) ?:
        throw IllegalArgumentException("Could not find a ViewHolderCreator with viewType $viewType.")
        return creator.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binders[position].bind(holder)
    }

    override fun getItemViewType(position: Int): Int {
        return binders[position].viewType
    }

    override fun getItemCount(): Int {
        return binders.size
    }
}