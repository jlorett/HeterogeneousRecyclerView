package com.joshualorett.heterogeneousrecyclerviewadaptersample.header

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * [RecyclerView.ViewHolder] for Header.
 * Created by Joshua on 5/23/2020.
 */
class HeaderViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val headerItemText: TextView = itemView.findViewById(R.id.headerItemText)
}