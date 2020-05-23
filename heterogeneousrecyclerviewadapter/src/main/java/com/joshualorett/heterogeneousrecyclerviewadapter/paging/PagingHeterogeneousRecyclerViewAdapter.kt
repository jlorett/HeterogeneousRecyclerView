package com.joshualorett.heterogeneousrecyclerviewadapter.paging

import androidx.collection.SparseArrayCompat
import android.view.ViewGroup
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.joshualorett.heterogeneousrecyclerviewadapter.ViewHolderCreator

/**
 * This adapter will trigger ViewHolder creation and binding in a paged fashion via its
 * ViewHolderCreators and ViewHolderBinders respectively.
 *
 * There only needs to be a single ViewHolderCreator for each type of layout supported.
 * The number of ViewHolderBinders should be in parity with the data set.
 *
 * Created by Joshua on 1/28/2019.
 */
class PagingHeterogeneousRecyclerViewAdapter(private var creators: SparseArrayCompat<ViewHolderCreator> = SparseArrayCompat(),
                                             diffUtilItemCallback: DiffUtil.ItemCallback<PagedViewHolderBinder<Any>> = defaultDiff)
    : PagedListAdapter<PagedViewHolderBinder<Any>, RecyclerView.ViewHolder>(diffUtilItemCallback) {

    fun addCreator(creator: ViewHolderCreator) {
        if(creators.containsKey(creator.id)) {
            throw IllegalArgumentException("A creator of type ${creator.id} already exists.")
        }
        creators.put(creator.id, creator)
    }

    fun removeCreatorByViewType(viewType: Int) {
        creators.remove(viewType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val creator = creators.get(viewType) ?:
        throw IllegalArgumentException("Could not find a ViewHolderCreator with viewType $viewType.")
        return creator.createViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val data = getItem(position)
        data?.bind(holder)
    }

    override fun getItemViewType(position: Int): Int {
        val data = getItem(position)
        return data?.id ?: 0
    }
}

private val defaultDiff: DiffUtil.ItemCallback<PagedViewHolderBinder<Any>> = object : DiffUtil.ItemCallback<PagedViewHolderBinder<Any>>() {
    override fun areItemsTheSame(oldItem: PagedViewHolderBinder<Any>, newItem: PagedViewHolderBinder<Any>): Boolean {
        return oldItem.itemTheSame(newItem)
    }

    override fun areContentsTheSame(oldItem: PagedViewHolderBinder<Any>, newItem: PagedViewHolderBinder<Any>): Boolean {
        return oldItem.contentTheSame(newItem)
    }
}