package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.header

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.R

/**
 * [RecyclerView.ViewHolder] for Header.
 * Created by Joshua on 6/11/2020.
 */
class HeaderViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val header: TextView = itemView.findViewById(R.id.header)
}