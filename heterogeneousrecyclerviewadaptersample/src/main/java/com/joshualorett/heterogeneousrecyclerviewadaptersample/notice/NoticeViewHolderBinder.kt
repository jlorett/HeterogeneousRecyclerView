package com.joshualorett.heterogeneousrecyclerviewadaptersample.notice

import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * Binds a [NoticeViewHolder].
 * Created by Joshua on 5/25/2020.
 */
class NoticeViewHolderBinder(private val notice: Notice) : ViewHolderBinder<Notice> {
    override val id: Int = R.layout.list_item_notice

    override fun bind(viewHolder: RecyclerView.ViewHolder) {
        val vh = viewHolder as NoticeViewHolder
        vh.headline.text = notice.headline
        vh.message.text = notice.message
        vh.action.text = notice.actionText
    }

    override fun emit(): Notice {
        return notice
    }
}