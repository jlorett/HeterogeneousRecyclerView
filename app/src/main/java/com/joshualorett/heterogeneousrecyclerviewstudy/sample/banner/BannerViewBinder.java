package com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderBinder;

/**
 * BannerViewHolder Binder.
 * Created by Joshua on 11/21/2016.
 */

public class BannerViewBinder implements ViewHolderBinder<Banner> {
    private Banner banner;

    public BannerViewBinder(Banner banner) {
        this.banner = banner;
    }

    @Override
    public int getViewType() {
        return R.layout.list_item_banner;
    }

    @Override
    public void bind(@NonNull RecyclerView.ViewHolder viewHolder) {
        ((BannerViewHolder)viewHolder).setBannerHeader("Banner");
    }

    @Override
    public Banner emit() {
        return banner;
    }
}
