package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.story

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.R

/**
 * [RecyclerView.ViewHolder] for Story.
 * Created by Joshua on 6/13/2020.
 */
class StoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val headline: TextView = itemView.findViewById(R.id.storyHeadline)
    val subject: TextView = itemView.findViewById(R.id.storySubject)
}