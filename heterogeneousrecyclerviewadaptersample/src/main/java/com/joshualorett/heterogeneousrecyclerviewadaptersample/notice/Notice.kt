package com.joshualorett.heterogeneousrecyclerviewadaptersample.notice

/**
 * Information Notice.
 * Created by Joshua on 5/25/2020.
 */
sealed class Notice {
    abstract val headline: String
    abstract val message: String
    abstract val actionText: String
}

data class Subscription(
    override val headline: String,
    override val message: String,
    override val actionText: String
) : Notice()