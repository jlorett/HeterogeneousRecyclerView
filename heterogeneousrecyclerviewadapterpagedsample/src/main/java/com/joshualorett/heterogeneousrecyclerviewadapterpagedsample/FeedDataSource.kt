package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample

import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import androidx.paging.PositionalDataSource
import com.joshualorett.heterogeneousrecyclerviewadapter.paging.PagedViewHolderBinder

/**
 * [PositionalDataSource] for the Feed.
 * Created by Joshua on 6/11/2020.
 */
class FeedDataSource(private val feedRepository: FeedRepository): PositionalDataSource<PagedViewHolderBinder<Any>>() {
    private var offset: Int = 0

    override fun loadRange(
        params: LoadRangeParams,
        callback: LoadRangeCallback<PagedViewHolderBinder<Any>>
    ) {
        val limit = params.loadSize
        val data = feedRepository.getData()
        callback.onResult(data.subList(offset, data.size).take(limit))
        offset = data.size
    }

    override fun loadInitial(
        params: LoadInitialParams,
        callback: LoadInitialCallback<PagedViewHolderBinder<Any>>
    ) {
        offset = 0
        val limit = params.requestedLoadSize
        val data = feedRepository.getData()
        callback.onResult(data.take(limit), offset, data.size)
        offset = data.size
    }

    class Factory(private val feedRepository: FeedRepository) : DataSource.Factory<Int, PagedViewHolderBinder<out Any>> () {
        val data = MutableLiveData<FeedDataSource>()

        override fun create(): DataSource<Int, PagedViewHolderBinder<out Any>> {
            val source = FeedDataSource(feedRepository)
            data.postValue(source)
            return source
        }
    }
}