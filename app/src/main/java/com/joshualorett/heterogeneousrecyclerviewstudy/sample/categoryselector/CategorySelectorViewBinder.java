package com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector;

import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderBinder;

/**
 * CategorySelectorViewHolder Binder.
 * Created by Joshua on 11/20/2016.
 */

public class CategorySelectorViewBinder implements ViewHolderBinder<Category> {
    private Category category;

    public CategorySelectorViewBinder(Category category) {
        this.category = category;
    }

    @Override
    public int getViewType() {
        return R.layout.list_item_category_selector;
    }

    @Override
    public void bind(RecyclerView.ViewHolder viewHolder) {
        ((CategorySelectorViewHolder)viewHolder).setButtonText("One", "Two",
                "Three", "Four", "Five", "Six");
    }

    @Override
    public Category emit() {
        return category;
    }
}
