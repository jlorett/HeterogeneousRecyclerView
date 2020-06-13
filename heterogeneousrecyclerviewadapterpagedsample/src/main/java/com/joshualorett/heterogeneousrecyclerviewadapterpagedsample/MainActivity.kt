package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.collection.SparseArrayCompat
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadapter.paging.PagedViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadapter.paging.PagingHeterogeneousRecyclerViewAdapter
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.header.HeaderViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.story.StoryViewHolderCreator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter = buildListAdapter()
        mainRecyclerView.adapter = adapter
        buildListDataObserver().observe(this, Observer {
            adapter.submitList(it)
        })
    }

    private fun buildListAdapter(): PagingHeterogeneousRecyclerViewAdapter {
        val viewHolderCreatorMap = SparseArrayCompat<ViewHolderCreator>()
        val headerViewHolderCreator = HeaderViewHolderCreator()
        val storyViewHolderCreator = StoryViewHolderCreator()
        viewHolderCreatorMap.put(headerViewHolderCreator.id, headerViewHolderCreator)
        viewHolderCreatorMap.put(storyViewHolderCreator.id, storyViewHolderCreator)
        return PagingHeterogeneousRecyclerViewAdapter(viewHolderCreatorMap)
    }

    private fun buildListDataObserver(): LiveData<PagedList<PagedViewHolderBinder<Any>>> {
        val pagingConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setPageSize(6)
            .build()
       return LivePagedListBuilder(FeedDataSource.Factory(FeedRepository()), pagingConfig).build()
    }
}
