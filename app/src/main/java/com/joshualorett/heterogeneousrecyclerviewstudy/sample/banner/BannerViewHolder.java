package com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Joshua on 11/21/2016.
 */

public class BannerViewHolder extends RecyclerView.ViewHolder {
    private ClickListener clickListener;

    public BannerViewHolder(View itemView) {
        super(itemView);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null) {
                    clickListener.onClick(getAdapterPosition());
                }
            }
        });
    }

    public void setClickListener(ClickListener listener) {
        this.clickListener = listener;
    }

    public interface ClickListener{
        void onClick(int position);
    }
}
