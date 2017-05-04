package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content;

import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;

/**
 * Created by Joshua on 12/10/2016.
 */

public class ContentViewModel implements ViewHolderModel {
    private Content content;

    public ContentViewModel(Content content) {
        this.content = content;
    }

    @Override
    public int getViewType() {
        return R.layout.content_card;
    }

    @Override
    public void bind(RecyclerView.ViewHolder viewHolder) {
        ((ContentViewHolder)viewHolder).cardTitleView.setText(content.getTitle());
    }

    @Override
    public Object emit() {
        return content;
    }
}
