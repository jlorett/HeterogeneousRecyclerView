package com.joshualorett.heterogeneousrecyclerviewadapterpagedsample

import com.joshualorett.heterogeneousrecyclerviewadapter.paging.PagedViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.header.HeaderViewHolderBinder
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.story.Story
import com.joshualorett.heterogeneousrecyclerviewadapterpagedsample.story.StoryViewHolderBinder

/**
 * Repository of feed data.
 * Created by Joshua on 6/11/2020.
 */
class FeedRepository {
    private val data: List<PagedViewHolderBinder<Any>> = listOf(
        HeaderViewHolderBinder("Stories from Today"),
        StoryViewHolderBinder(Story("Money and modern life", "Cities")),
        StoryViewHolderBinder(Story("The Effects of Tectonic Force on Mountain Height", "Geology")),
        StoryViewHolderBinder(Story("Random Search Wired Into Animals May Help Them Hunt", "Behavior")),
        StoryViewHolderBinder(Story("Quantum Matter Orbits Earth", "Physics")),
        HeaderViewHolderBinder("Trending Articles"),
        StoryViewHolderBinder(Story("Why Sleep Deprivation Kills", "Biology")),
        StoryViewHolderBinder(Story("Why Our Perpetual Energy Puzzle Fails", "Physics")),
        StoryViewHolderBinder(Story("Graduate Student Solves Decades-Old Conway Knot Problem", "Mathematics"))
    )

    fun getData() : List<PagedViewHolderBinder<Any>> {
        return data
    }
}