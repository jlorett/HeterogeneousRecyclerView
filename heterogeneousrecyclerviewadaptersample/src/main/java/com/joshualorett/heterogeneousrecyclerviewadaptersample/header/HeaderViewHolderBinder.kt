package com.joshualorett.heterogeneousrecyclerviewadaptersample.header

import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * Binds [HeaderViewHolder].
 * Created by Joshua on 5/23/2020.
 */
class HeaderViewHolderBinder(private val story: HeaderStory) : ViewHolderBinder<HeaderStory> {
    override val id: Int
        get() = R.layout.list_item_header

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        val vh = viewHolder as HeaderViewHolder
        vh.headerItemText.text = story.header
        vh.subHeader.text = story.subHeader
        Glide.with(vh.itemView)
            .load(story.image)
            .into(vh.headerImage)
    }

    override fun emit(): HeaderStory {
        return story
    }
}