package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import android.support.v4.util.SparseArrayCompat;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreatorManager;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorCreator;

/**
 * Created by Joshua on 11/20/2016.
 */

public class SampleViewHolderCreatorManager implements ViewHolderCreatorManager {
    private SparseArrayCompat<ViewHolderCreator> creators;

    public SampleViewHolderCreatorManager(ViewHolderCreator[] viewHolderCreators) {
        creators = new SparseArrayCompat<>();

        for(ViewHolderCreator viewHolderCreator : viewHolderCreators) {
            creators.put(viewHolderCreator.getViewType(), viewHolderCreator);
        }
    }

    @Override
    public void addCreator(ViewHolderCreator creator) {
        creators.put(creator.getViewType(), creator);
    }

    @Override
    public void removeCreator(ViewHolderCreator creator) {
        creators.remove(creators.indexOfValue(creator));
    }

    @Override
    public void removeCreator(int viewType) {
        creators.remove(viewType);
    }

    @Override
    public void clear() {
        creators.clear();
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent, int viewType) {
        ViewHolderCreator currentCreator = creators.get(viewType);

        if(currentCreator == null) {
            throw new NullPointerException("Could not find creator.");
        }

        return currentCreator.createViewHolder(parent);
    }
}
