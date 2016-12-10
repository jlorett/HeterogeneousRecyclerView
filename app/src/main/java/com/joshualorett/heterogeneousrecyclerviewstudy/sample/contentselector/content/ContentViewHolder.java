package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Joshua on 12/10/2016.
 */

public class ContentViewHolder extends RecyclerView.ViewHolder {
    private ContentClickListener clickListener;

    public ContentViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null) {
                    clickListener.onContentClick(getAdapterPosition());
                }
            }
        });
    }

    public void setContentClickListener(ContentClickListener listener) {
        clickListener = listener;
    }

    public interface ContentClickListener {
        void onContentClick(int position);
    }
}
