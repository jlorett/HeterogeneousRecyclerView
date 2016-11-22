package com.joshualorett.heterogeneousrecyclerviewstudy.lib;

import android.support.v7.widget.RecyclerView;

/**
 * A view model for a view holder.
 * Created by Joshua on 11/20/2016.
 */

public interface ViewHolderModel {
    int getViewType();

    void bind(RecyclerView.ViewHolder viewHolder);
}
