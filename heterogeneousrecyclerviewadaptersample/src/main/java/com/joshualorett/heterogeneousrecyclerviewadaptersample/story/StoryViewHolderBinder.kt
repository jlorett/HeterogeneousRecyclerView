package com.joshualorett.heterogeneousrecyclerviewadaptersample.story

import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * Binds [StoryViewHolder].
 * Created by Joshua on 5/24/2020.
 */
class StoryViewHolderBinder(private val story: Story): ViewHolderBinder<Story> {
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
}