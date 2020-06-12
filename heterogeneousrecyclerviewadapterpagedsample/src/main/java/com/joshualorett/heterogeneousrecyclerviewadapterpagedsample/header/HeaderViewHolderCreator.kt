package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.header

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.R

/**
 * Creates [HeaderViewHolder].
 * Created by Joshua on 6/11/2020.
 */
class HeaderViewHolderCreator: ViewHolderCreator {
    override val id: Int
        get() = R.layout.list_item_header

    override fun createViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return HeaderViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.list_item_header, parent, false))
    }
}