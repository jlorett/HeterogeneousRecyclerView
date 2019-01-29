package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderBinder;

/**
 * ContentView Binder.
 * Created by Joshua on 12/10/2016.
 */

public class ContentViewBinder implements ViewHolderBinder<Content> {
    private Content content;

    public ContentViewBinder(Content content) {
        this.content = content;
    }

    @Override
    public int getViewType() {
        return R.layout.content_card;
    }

    @Override
    public void bind(@NonNull RecyclerView.ViewHolder viewHolder) {
        ((ContentViewHolder)viewHolder).cardTitleView.setText(content.getTitle());
    }

    @Override
    public Content emit() {
        return content;
    }
}
