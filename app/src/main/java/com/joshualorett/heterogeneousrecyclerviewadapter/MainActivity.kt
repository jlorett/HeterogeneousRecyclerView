package com.joshualorett.heterogeneousrecyclerviewadapter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.collection.SparseArrayCompat
import com.joshualorett.heterogeneousrecyclerviewadapter.header.HeaderViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadapter.header.HeaderViewHolderCreator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val adapter = buildListAdapter()
        adapter.binders = buildListData()
        mainRecyclerView.adapter = adapter
    }

    private fun buildListAdapter(): HeterogeneousRecyclerViewAdapter {
        val headerViewHolderCreator = HeaderViewHolderCreator()
        val viewHolderCreatorMap = SparseArrayCompat<ViewHolderCreator>()
        viewHolderCreatorMap.append(headerViewHolderCreator.id, headerViewHolderCreator)
        return HeterogeneousRecyclerViewAdapter(viewHolderCreatorMap)
    }

    private fun buildListData(): List<ViewHolderBinder<Any>> {
        val headerViewHolderBinder = HeaderViewHolderBinder("Welcome")
        return listOf(headerViewHolderBinder)
    }
}
