package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;

/**
 * Created by Joshua on 12/10/2016.
 */

public class ContentCreator implements ViewHolderCreator {
    private ContentViewHolder.ContentClickListener contentClickListener;

    public void setContentClickListener(ContentViewHolder.ContentClickListener listener) {
        contentClickListener = listener;
    }

    @Override
    public int getViewType() {
        return R.layout.content_card;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        ContentViewHolder viewHolder = new ContentViewHolder(LayoutInflater.from(parent.getContext()).inflate(getViewType(), parent, false));
        viewHolder.setContentClickListener(contentClickListener);
        return viewHolder;
    }
}
