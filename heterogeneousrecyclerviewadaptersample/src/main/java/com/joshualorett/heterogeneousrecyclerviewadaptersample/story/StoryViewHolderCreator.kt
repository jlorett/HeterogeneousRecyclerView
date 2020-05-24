package com.joshualorett.heterogeneousrecyclerviewadaptersample.story

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * Creates a [StoryViewHolder].
 * Created by Joshua on 5/24/2020.
 */
class StoryViewHolderCreator(override val id: Int = R.layout.list_item_story) :
    ViewHolderCreator {
    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(id, parent, false))
    }
}