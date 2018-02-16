package com.joshualorett.heterogeneousrecyclerviewstudy.lib;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * RecyclerView adapter using ViewHolderCreators to create ViewHolders and handle callbacks and
 * ViewHolderBinders to bind content.
 *
 * Created by Joshua on 11/20/2016.
 */

public class HeterogeneousRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ViewHolderBinder[] binders;

    private SparseArrayCompat<ViewHolderCreator> creators;

    public HeterogeneousRecyclerViewAdapter(ViewHolderCreator[] viewHolderCreators) {
        binders = new ViewHolderBinder[0];

        if (viewHolderCreators != null) {
            creators = new SparseArrayCompat<>(viewHolderCreators.length);

            for (ViewHolderCreator creator : viewHolderCreators) {
                creators.put(creator.getViewType(), creator);
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolderCreator creator = creators.get(viewType);

        if (creator == null) {
            throw new NullPointerException("Could not find creator.");
        }

        return creator.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        binders[position].bind(holder);
    }

    @Override
    public int getItemViewType(int position) {
        return binders[position].getViewType();
    }

    @Override
    public int getItemCount() {
        return binders.length;
    }

    public void setData(ViewHolderBinder[] viewModels) {
        this.binders = viewModels;
    }
}
