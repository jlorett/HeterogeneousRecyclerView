package com.joshualorett.heterogeneousrecyclerviewadapter.lib

import androidx.recyclerview.widget.RecyclerView

/**
 * Bind a ViewHolder with data of type T.
 * T is a covariant type parameter, in other words "ViewHolderBinder is a producer of T's"
 * Created by Joshua on 11/20/2016.
 */

interface ViewHolderBinder<out T> {
    /***
     * Get the view type this binder is associated with. This should match at least one
     * ViewHolderCreator's view type.
     * @return View type
     */
    val viewType: Int

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