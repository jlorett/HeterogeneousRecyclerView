package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;

/**
 * ContentSelectorViewHolder ViewModel.
 * Created by Joshua on 11/21/2016.
 */

public class ContentSelectorViewModel implements ViewHolderModel {
    private ViewHolderModel[] viewHolderModels;

    public ContentSelectorViewModel(){
        this.viewHolderModels = new ViewHolderModel[0];
    }

    public void setViewHolderModels(ViewHolderModel[] viewHolderModels) {
        this.viewHolderModels = viewHolderModels;
    }

    @Override
    public int getViewType() {
        return R.layout.list_item_content_selector;
    }

    @Override
    public void bind(RecyclerView.ViewHolder viewHolder) {
        ContentSelectorViewHolder contentViewHolder = (ContentSelectorViewHolder) viewHolder;
        contentViewHolder.setData(viewHolderModels);
    }
}
