package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewModel;

/**
 * ContentSelectorViewHolder ViewModel.
 * Created by Joshua on 11/21/2016.
 */

public class ContentSelectorViewModel implements ViewHolderModel<ContentViewModel[]> {
    private ContentViewModel[] viewHolderModels;

    public ContentSelectorViewModel(){
        this.viewHolderModels = new ContentViewModel[0];
    }

    public ContentSelectorViewModel(ContentViewModel[] viewHolderModels) {
        this.viewHolderModels = viewHolderModels;
    }

    public void setViewHolderModels(ContentViewModel[] viewHolderModels) {
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

    @Override
    public ContentViewModel[] emit() {
        return viewHolderModels;
    }
}
