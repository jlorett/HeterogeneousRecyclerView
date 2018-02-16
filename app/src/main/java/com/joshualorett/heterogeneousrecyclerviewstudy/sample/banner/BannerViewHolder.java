package com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;

/**
 * ViewHolder for banner.
 * Created by Joshua on 11/21/2016.
 */

public class BannerViewHolder extends RecyclerView.ViewHolder {
    private ClickListener clickListener;

    private TextView header;

    public BannerViewHolder(View itemView) {
        super(itemView);

        header = (TextView) itemView.findViewById(R.id.banner_header);

        itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(clickListener != null) {
                    clickListener.onClick(getAdapterPosition());
                }
            }
        });
    }

    public void setBannerHeader(String text) {
        header.setText(text);
    }

    public void setClickListener(ClickListener listener) {
        this.clickListener = listener;
    }

    public interface ClickListener{
        void onClick(int position);
    }
}
