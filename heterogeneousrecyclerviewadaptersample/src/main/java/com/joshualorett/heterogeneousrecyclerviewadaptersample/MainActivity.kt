package com.joshualorett.heterogeneousrecyclerviewadaptersample

import android.content.res.Resources
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.collection.SparseArrayCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import com.joshualorett.heterogeneousrecyclerviewadapter.HeterogeneousRecyclerViewAdapter
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadaptersample.header.HeaderViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadaptersample.header.HeaderViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadaptersample.notice.NoticeViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadaptersample.notice.NoticeViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadaptersample.story.StoryViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadaptersample.story.StoryViewHolderCreator
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private val storyRepository = FeedRepository()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dividerItemDecoration = DividerItemDecoration(this, DividerItemDecoration.VERTICAL)
        val divider = ContextCompat.getDrawable(this, R.drawable.divider) ?: throw Resources.NotFoundException("Divider resource not found.")
        dividerItemDecoration.setDrawable(divider)
        mainRecyclerView.addItemDecoration(dividerItemDecoration)
        val adapter = buildListAdapter()
        adapter.binders = buildListData()
        mainRecyclerView.adapter = adapter
    }

    private fun buildListAdapter(): HeterogeneousRecyclerViewAdapter {
        val headerViewHolderCreator = HeaderViewHolderCreator()
        val storyViewHolderCreator = StoryViewHolderCreator()
        val noticeViewHolderCreator = NoticeViewHolderCreator()
        val viewHolderCreatorMap = SparseArrayCompat<ViewHolderCreator>()
        viewHolderCreatorMap.append(headerViewHolderCreator.id, headerViewHolderCreator)
        viewHolderCreatorMap.append(storyViewHolderCreator.id, storyViewHolderCreator)
        viewHolderCreatorMap.append(noticeViewHolderCreator.id, noticeViewHolderCreator)
        return HeterogeneousRecyclerViewAdapter(viewHolderCreatorMap)
    }

    private fun buildListData(): List<ViewHolderBinder<Any>> {
        val headerViewHolderBinder = HeaderViewHolderBinder(storyRepository.getHeaderStory())
        val storyViewHolderBinders: List<ViewHolderBinder<Any>> = storyRepository.getStories().map { story -> StoryViewHolderBinder(story) }
        val noticeViewHolderBinder = NoticeViewHolderBinder(storyRepository.getNotice())
        val data: MutableList<ViewHolderBinder<Any>> = mutableListOf(headerViewHolderBinder)
        data.addAll(storyViewHolderBinders)
        data.add(noticeViewHolderBinder)
        return data
    }
}
