package com.joshualorett.heterogeneousrecyclerviewadaptersample.header

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * Creates [HeaderViewHolder].
 * Created by Joshua on 5/23/2020.
 */
class HeaderViewHolderCreator(override val id: Int = R.layout.list_item_header) : ViewHolderCreator {
    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return HeaderViewHolder(LayoutInflater.from(parent.context).inflate(id, parent, false))
    }
}