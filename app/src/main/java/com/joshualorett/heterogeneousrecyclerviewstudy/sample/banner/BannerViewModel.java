package com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner;

import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;

/**
 * Created by Joshua on 11/21/2016.
 */

public class BannerViewModel implements ViewHolderModel {
    @Override
    public int getViewType() {
        return R.layout.list_item_banner;
    }

    @Override
    public void bind(RecyclerView.ViewHolder viewHolder) {

    }
}
