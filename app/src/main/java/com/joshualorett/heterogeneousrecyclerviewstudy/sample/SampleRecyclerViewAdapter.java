package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorCreator;

/**
 * Created by Joshua on 11/20/2016.
 */

public class SampleRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private ViewHolderModel[] viewModels;

    private SampleViewHolderCreatorManager viewHolderCreatorManager;

    public SampleRecyclerViewAdapter() {
        viewModels = new ViewHolderModel[0];

        viewHolderCreatorManager = new SampleViewHolderCreatorManager(new ViewHolderCreator[] {
                new CategorySelectorCreator(),
                new ContentSelectorCreator(),
                new BannerCreator()});
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return viewHolderCreatorManager.createViewHolder(parent, viewType);
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
