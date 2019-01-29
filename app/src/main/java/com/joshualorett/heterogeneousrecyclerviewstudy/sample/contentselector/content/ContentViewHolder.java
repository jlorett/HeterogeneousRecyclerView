package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content;

import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;

/**
 * ViewHolder for content.
 * Created by Joshua on 12/10/2016.
 */

public class ContentViewHolder extends RecyclerView.ViewHolder {
    private ContentClickListener clickListener;

    public TextView cardTitleView;

    public ContentViewHolder(View itemView) {
        super(itemView);

        cardTitleView = (TextView) itemView.findViewById(R.id.card_title);

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
