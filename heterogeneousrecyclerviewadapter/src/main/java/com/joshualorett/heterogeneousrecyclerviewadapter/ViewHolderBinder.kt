package com.joshualorett.heterogeneousrecyclerviewadapter

import androidx.recyclerview.widget.RecyclerView

/**
 * Bind a ViewHolder with data of type T.
 * T is a covariant type parameter, in other words "ViewHolderBinder is a producer of T's"
 * Created by Joshua on 11/20/2016.
 */

interface ViewHolderBinder<out T> {
    /***
     * Get the view id this binder is associated with. This should match the id of a ViewHolderCreator.
     * @return identifier for the view.
     */
    val id: Int

    /***
     * Bind ViewHolder with data T held.
     * @param viewHolder the ViewHolder we want to bind data to.
     */
    fun bind(viewHolder: RecyclerView.ViewHolder)

    /***
     * Emit that data this binder holds.
     * @return data of type T.
     */
    fun emit(): T
}