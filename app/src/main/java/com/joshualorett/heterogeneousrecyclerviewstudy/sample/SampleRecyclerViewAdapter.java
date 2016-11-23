package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;

/**
 * Created by Joshua on 11/20/2016.
 */

public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ViewHolderModel[] viewModels;

    private SparseArrayCompat<ViewHolderCreator> creators;;

    public SampleRecyclerViewAdapter(ViewHolderCreator[] viewHolderCreators) {
        viewModels = new ViewHolderModel[0];

        if(viewHolderCreators != null) {
            creators = new SparseArrayCompat<>(viewHolderCreators.length);

            for (ViewHolderCreator creator : viewHolderCreators) {
                creators.put(creator.getViewType(), creator);
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolderCreator creator = creators.get(viewType);

        if(creator == null) {
            throw new NullPointerException("Could not find creator.");
        }

        return creator.createViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        viewModels[position].bind(holder);
    }

    @Override
    public int getItemViewType(int position) {
        return viewModels[position].getViewType();
    }

    @Override
    public int getItemCount() {
        return viewModels.length;
    }

    public void setData(ViewHolderModel[] viewModels) {
        this.viewModels = viewModels;
    }
}
