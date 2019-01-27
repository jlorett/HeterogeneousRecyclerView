package com.joshualorett.heterogeneousrecyclerviewstudy.lib

import android.support.v4.util.SparseArrayCompat
import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * This adapter will trigger ViewHolder creation and binding via its ViewHolderCreators and
 * ViewHolderBinders respectively.
 *
 * There should be a single ViewHolderCreator for each type of layout supported.
 * The number of ViewHolderBinders should be in parity with the data set.
 *
 * Created by Joshua on 11/20/2016.
 */

class HeterogeneousRecyclerViewAdapter(viewHolderCreators: Array<ViewHolderCreator>?) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    /***
     * Get the data for your list.
     * @return the ViewHolderBinders that bind data to your ViewHolders.
     */
    /***
     * Set the data for your list.
     * @param binders the ViewHolderBinder you want the adapter to bind to the ViewHolder.
     */
    var binders: Array<ViewHolderBinder<*>>? = null

    private var creators: SparseArrayCompat<ViewHolderCreator>? = null

    init {
        binders = arrayOfNulls(0)

        if (viewHolderCreators != null) {
            creators = SparseArrayCompat(viewHolderCreators.size)

            for (creator in viewHolderCreators) {
                creators!!.put(creator.viewType, creator)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val creator = creators!!.get(viewType)
                ?: throw NullPointerException(String.format("Could not find a ViewHolderCreator with viewType %d.", viewType))

        return creator.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        binders!![position].bind(holder)
    }

    override fun getItemViewType(position: Int): Int {
        return binders!![position].viewType
    }

    override fun getItemCount(): Int {
        return binders!!.size
    }
}
