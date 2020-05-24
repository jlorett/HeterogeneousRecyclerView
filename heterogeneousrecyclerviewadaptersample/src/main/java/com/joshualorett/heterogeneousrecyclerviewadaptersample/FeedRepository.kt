package com.joshualorett.heterogeneousrecyclerviewadaptersample

import com.joshualorett.heterogeneousrecyclerviewadaptersample.header.HeaderStory
import com.joshualorett.heterogeneousrecyclerviewadaptersample.story.Story

/**
 * Repository of feed data.
 * Created by Joshua on 5/24/2020.
 */
class FeedRepository {
    // Headers
    private val tiger = HeaderStory("Tracking Tigers", R.drawable.tiger, "Surveying the elusive cats.")
    private val jellyFish = HeaderStory("The Secret Lives of Jellyfish", R.drawable.jellyfish, "How the jellyfish play an important role in the marine food web.")
    private val desert = HeaderStory("Desert Sounds", R.drawable.desert, "An auditory exploration of the Sahara.")

    // Stories
    private val climate =  Story("The Global Surface Temperature Change of the Last 50 Years", "Climate")
    private val nebula = Story("The Gum Nebula", "Astronomy")
    private val waterfall = Story("Emerging Trends in Freshwater Availability", "Hydrology")

    fun getHeaderStory(): HeaderStory {
        return listOf(tiger, jellyFish, desert).random()
    }

    fun getStories(): List<Story> {
        return listOf(climate, nebula, waterfall)
    }
}