package com.joshualorett.heterogeneousrecyclerviewadapter.header

import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.R
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderBinder

/**
 * Binds [HeaderViewHolder].
 * Created by Joshua on 5/23/2020.
 */
class HeaderViewHolderBinder(private val headerText: String) : ViewHolderBinder<String> {
    override val id: Int
        get() = R.layout.list_item_header

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        (viewHolder as HeaderViewHolder).headerItemText.text = headerText
    }

    override fun emit(): String {
        return headerText
    }
}