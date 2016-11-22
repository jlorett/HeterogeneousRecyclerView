package com.joshualorett.heterogeneousrecyclerviewstudy.lib;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Creates a view holder.
 * Created by Joshua on 11/20/2016.
 */

public interface ViewHolderCreator {
    /***
     * Get the view holders view type.
     * @return View type
     */
    int getViewType();

    /***
     * Create a new view holder.
     * @param parent {@inheritDoc}
     * @return View holder.
     */
    RecyclerView.ViewHolder createViewHolder(ViewGroup parent);
}
