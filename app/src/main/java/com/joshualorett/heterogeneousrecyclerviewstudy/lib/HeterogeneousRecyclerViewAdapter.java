package com.joshualorett.heterogeneousrecyclerviewstudy.lib;

import android.support.annotation.NonNull;
import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

/**
 * This adapter will trigger ViewHolder creation and binding via its ViewHolderCreators and
 * ViewHolderBinders respectively.
 *
 * There should be a single ViewHolderCreator for each type of layout supported.
 * The number of ViewHolderBinders should be in parity with the data set.
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

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewHolderCreator creator = creators.get(viewType);

        if (creator == null) {
            throw new NullPointerException(String.format("Could not find a ViewHolderCreator with viewType %d.", viewType));
        }

        return creator.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
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
