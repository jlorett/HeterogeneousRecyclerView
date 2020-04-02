package com.joshualorett.heterogeneousrecyclerviewadapter.paging

import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderBinder

/**
 * A [ViewHolderBinder] that works with [PagingHeterogeneousRecyclerViewAdapter]
 * Created by Joshua on 1/28/2019.
 */

interface PagedViewHolderBinder<out T> : ViewHolderBinder<T> {
    fun itemTheSame(binder: PagedViewHolderBinder<Any>) : Boolean
    fun contentTheSame(binder: PagedViewHolderBinder<Any>) : Boolean
}