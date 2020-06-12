package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample

import com.joshualorett.heterogeneousrecyclerviewadapter.paging.PagedViewHolderBinder

/**
 * Repository of feed data.
 * Created by Joshua on 6/11/2020.
 */
class FeedRepository {
    private val data = emptyList<PagedViewHolderBinder<Any>>()

    fun getData() : List<PagedViewHolderBinder<Any>> {
        return data
    }
}