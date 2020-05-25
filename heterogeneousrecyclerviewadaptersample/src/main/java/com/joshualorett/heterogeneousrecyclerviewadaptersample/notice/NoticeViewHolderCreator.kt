package com.joshualorett.heterogeneousrecyclerviewadaptersample.notice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * Creates a [NoticeViewHolder].
 * Created by Joshua on 5/25/2020.
 */
class NoticeViewHolderCreator: ViewHolderCreator {
    override val id: Int
        get() = R.layout.list_item_notice

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NoticeViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_notice, parent, false))
    }
}