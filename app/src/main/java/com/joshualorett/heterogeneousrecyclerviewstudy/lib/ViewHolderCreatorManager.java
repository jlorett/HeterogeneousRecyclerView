package com.joshualorett.heterogeneousrecyclerviewstudy.lib;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * Created by Joshua on 11/20/2016.
 */

public interface ViewHolderCreatorManager {
    void addCreator(ViewHolderCreator creator);

    void removeCreator(ViewHolderCreator creator);

    void removeCreator(int viewType);

    void clear();

    RecyclerView.ViewHolder createViewHolder(ViewGroup parent, int viewType);
}
