package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.story

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.R

/**
 * Creates a [StoryViewHolder].
 * Created by Joshua on 6/13/2020.
 */
class StoryViewHolderCreator(override val id: Int = R.layout.list_item_story) :
    ViewHolderCreator {
    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return StoryViewHolder(LayoutInflater.from(parent.context).inflate(id, parent, false))
    }
}