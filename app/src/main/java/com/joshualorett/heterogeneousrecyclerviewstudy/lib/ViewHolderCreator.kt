package com.joshualorett.heterogeneousrecyclerviewstudy.lib

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup

/**
 * Create a view holder.
 * Created by Joshua on 11/20/2016.
 */

interface ViewHolderCreator {
    /***
     * Get the view holders view type. This should match at least one ViewHolderBinder's view type.
     * @return View type
     */
    val viewType: Int

    /***
     * Create a new view holder.
     *
     * @param parent {@inheritDoc}
     * @return View holder.
     */
    fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder
}
