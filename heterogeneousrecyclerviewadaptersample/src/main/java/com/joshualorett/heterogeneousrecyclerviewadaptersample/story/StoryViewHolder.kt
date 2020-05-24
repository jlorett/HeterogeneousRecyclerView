package com.joshualorett.heterogeneousrecyclerviewadaptersample.story

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadaptersample.R

/**
 * [RecyclerView.ViewHolder] for Story.
 * Created by Joshua on 5/24/2020.
 */
class StoryViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
    val headline: TextView = itemView.findViewById(R.id.storyHeadline)
    val subject: TextView = itemView.findViewById(R.id.storySubject)
}