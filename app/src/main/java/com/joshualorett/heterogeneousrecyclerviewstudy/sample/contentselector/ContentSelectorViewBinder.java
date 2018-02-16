package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderBinder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewBinder;

/**
 * ContentSelectorViewHolder Binder.
 * Created by Joshua on 11/21/2016.
 */

public class ContentSelectorViewBinder implements ViewHolderBinder<ContentViewBinder[]> {
    private ContentViewBinder[] binders;

    public ContentSelectorViewBinder(){
        this.binders = new ContentViewBinder[0];
    }

    public ContentSelectorViewBinder(ContentViewBinder[] binders) {
        this.binders = binders;
    }

    public void setBinders(ContentViewBinder[] binders) {
        this.binders = binders;
    }

    @Override
    public int getViewType() {
        return R.layout.list_item_content_selector;
    }

    @Override
    public void bind(RecyclerView.ViewHolder viewHolder) {
        ContentSelectorViewHolder contentViewHolder = (ContentSelectorViewHolder) viewHolder;
        contentViewHolder.setData(binders);
    }

    @Override
    public ContentViewBinder[] emit() {
        return binders;
    }
}
