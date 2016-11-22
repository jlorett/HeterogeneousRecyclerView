package com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector;

import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;

/**
 * Created by Joshua on 11/20/2016.
 */

public class CategorySelectorViewModel implements ViewHolderModel {
    public CategorySelectorViewModel() {}

    @Override
    public int getViewType() {
        return R.layout.list_item_category_selector;
    }

    @Override
    public void bind(RecyclerView.ViewHolder viewHolder) {
    }
}
