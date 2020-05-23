package com.joshualorett.heterogeneousrecyclerviewadapter

import androidx.recyclerview.widget.RecyclerView
import android.view.ViewGroup

/**
 * Create a view holder.
 * Created by Joshua on 11/20/2016.
 */

interface ViewHolderCreator {
    /***
     * Get the view holders id. This should match a ViewHolderBinder id.
     * @return identifier for the view.
     */
    val id: Int

    /***
     * Create a new view holder.
     *
     * @param parent {@inheritDoc}
     * @return View holder.
     */
    fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
}