package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;

/**
 * Creates a ContentSelectorViewHolder.
 * Created by Joshua on 11/21/2016.
 */

public class ContentSelectorCreator implements ViewHolderCreator {
    private ContentSelectorViewHolder.HeaderActionClickListener actionClickListener;

    private ContentSelectorViewHolder.ItemClickListener itemClickListener;

    public void setHeaderActionClickListener(ContentSelectorViewHolder.HeaderActionClickListener actionClickListener) {
        this.actionClickListener = actionClickListener;
    }

    public void setItemClickListener(ContentSelectorViewHolder.ItemClickListener listener) {
        itemClickListener = listener;
    }

    @Override
    public int getViewType() {
        return R.layout.list_item_content_selector;
    }

    @Override
    public RecyclerView.ViewHolder createViewHolder(ViewGroup parent) {
        ContentSelectorViewHolder viewHolder = new ContentSelectorViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(getViewType(), parent, false));
        viewHolder.setHeaderActionClickListener(actionClickListener);
        viewHolder.setItemClickListener(itemClickListener);
        return viewHolder;
    }
}
