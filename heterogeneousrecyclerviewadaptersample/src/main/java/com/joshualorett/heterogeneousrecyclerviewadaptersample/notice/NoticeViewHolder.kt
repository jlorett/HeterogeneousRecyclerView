package com.joshualorett.heterogeneousrecyclerviewadaptersample.notice

import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * [RecyclerView.ViewHolder] for Notice.
 * Created by Joshua on 5/25/2020.
 */
class NoticeViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val headline: TextView = itemView.findViewById(R.id.noticeHeadline)
    val message: TextView = itemView.findViewById(R.id.noticeMessage)
    val action: Button = itemView.findViewById(R.id.noticeAction)
}