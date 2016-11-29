package com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;

/**
 * Creates a BannerViewHolder.
 * Created by Joshua on 11/21/2016.
 */

public class BannerCreator implements ViewHolderCreator {
    @Override
    public int getViewType() {
        return R.layout.list_item_banner;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        return new BannerViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getViewType(), parent, false));
    }
}
