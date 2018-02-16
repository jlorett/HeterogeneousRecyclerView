package com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner;

/**
 * Data for the BannerViewHolder.
 * Created by Joshua on 5/3/2017.
 */

public class Banner {
    private String text;

    public Banner(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
