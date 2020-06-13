package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.story

import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.paging.PagedViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.R

/**
 * Binds [StoryViewHolder].
 * Created by Joshua on 6/13/2020.
 */
class StoryViewHolderBinder(private val story: Story): PagedViewHolderBinder<Story> {
    override val id: Int
        get() = R.layout.list_item_story

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        val vh = viewHolder as StoryViewHolder
        vh.headline.text = story.header
        vh.subject.text = story.subject
    }

    override fun emit(): Story {
        return story
    }

    override fun itemTheSame(binder: PagedViewHolderBinder<Any>): Boolean {
        return story == binder.emit()
    }

    override fun contentTheSame(binder: PagedViewHolderBinder<Any>): Boolean {
        val otherStory = binder.emit() as Story
        return story.header == otherStory.header && story.subject == otherStory.subject
    }
}