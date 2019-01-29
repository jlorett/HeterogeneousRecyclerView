package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderBinder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewBinder;

import java.util.ArrayList;
import java.util.List;

/**
 * ContentSelectorViewHolder Binder.
 * Created by Joshua on 11/21/2016.
 */

public class ContentSelectorViewBinder implements ViewHolderBinder<List<ContentViewBinder>> {
    private List<ContentViewBinder> binders;

    public ContentSelectorViewBinder(){
        this.binders = new ArrayList<>(0);
    }

    public ContentSelectorViewBinder(List<ContentViewBinder> binders) {
        this.binders = binders;
    }

    @Override
    public int getViewType() {
        return R.layout.list_item_content_selector;
    }

    @Override
    public void bind(@NonNull RecyclerView.ViewHolder viewHolder) {
        ContentSelectorViewHolder contentViewHolder = (ContentSelectorViewHolder) viewHolder;
        contentViewHolder.setData(binders);
    }

    @Override
    public List<ContentViewBinder> emit() {
        return binders;
    }
}
