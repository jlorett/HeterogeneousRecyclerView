package com.joshualorett.heterogeneousrecyclerviewstudy.lib.paging

import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderBinder

/**
 * A [ViewHolderBinder] that works with [PagedListAdapter]
 * Created by Joshua on 1/28/2019.
 */

interface PagedViewHolderBinder<out T> : ViewHolderBinder<T> {
    fun itemTheSame(binder: PagedViewHolderBinder<Any>) : Boolean
    fun contentTheSame(binder: PagedViewHolderBinder<Any>) : Boolean
}