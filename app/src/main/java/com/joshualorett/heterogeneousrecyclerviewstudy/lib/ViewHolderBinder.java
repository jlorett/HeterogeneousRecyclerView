package com.joshualorett.heterogeneousrecyclerviewstudy.lib;

import android.support.v7.widget.RecyclerView;

/**
 * Bind a ViewHolder with provided data T.
 * Created by Joshua on 11/20/2016.
 */

public interface ViewHolderBinder<T> {
    /***
     * Get the view type this binder is associated with.
     *
     * @return View type
     */
    int getViewType();

    /***
     * Bind ViewHolder with data T held.
     * @param viewHolder the viewholder we want to bind data to.
     */
    void bind(RecyclerView.ViewHolder viewHolder);

    /***
     * Emit that data this binder holds.
     * @return data of type T.
     */
    T emit();
}
