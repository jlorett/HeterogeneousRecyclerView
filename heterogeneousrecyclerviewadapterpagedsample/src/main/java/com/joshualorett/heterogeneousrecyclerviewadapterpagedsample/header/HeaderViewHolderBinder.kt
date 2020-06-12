package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.header

import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.paging.PagedViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.R

/**
 * Binds [HeaderViewHolder].
 * Created by Joshua on 6/11/2020.
 */
class HeaderViewHolderBinder(private val headerText: String): PagedViewHolderBinder<String> {
    override val id: Int
        get() = R.layout.list_item_header

    override fun itemTheSame(binder: PagedViewHolderBinder<Any>): Boolean {
        return headerText == binder.emit()
    }

    override fun contentTheSame(binder: PagedViewHolderBinder<Any>): Boolean {
        return headerText == binder.emit()
    }

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        (viewHolder as HeaderViewHolder).header.text = headerText
    }

    override fun emit(): String {
        return headerText
    }
}