package com.joshualorett.heterogeneousrecyclerviewstudy.lib.paging

import android.view.ViewGroup
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator

import org.junit.Assert.*
import org.junit.Test
import org.mockito.Mockito
/**
 * Test PagingHeterogeneousRecyclerViewAdapter.
 *
 * Created by Joshua on 1/28/2019.
 */
class PagingHeterogeneousRecyclerViewAdapterTest {

    @Test
    fun adapterDefaultsToEmpty() {
        val adapter = PagingHeterogeneousRecyclerViewAdapter()
        assertEquals(0, adapter.itemCount)
    }

    @Test
    fun defaultHasEmptyBinders() {
        assertEquals(0, PagingHeterogeneousRecyclerViewAdapter().itemCount)
    }

    @Test(expected = IllegalArgumentException::class)
    fun failIfWeTryToAddDuplicateKeys() {
        val mockCreator = Mockito.mock(ViewHolderCreator::class.java)
        Mockito.`when`(mockCreator.viewType).thenReturn(1)
        val adapter = PagingHeterogeneousRecyclerViewAdapter(listOf(mockCreator))
        adapter.addCreator(mockCreator)
    }

    @Test
    fun removeCreator() {
        val mockCreator = Mockito.mock(ViewHolderCreator::class.java)
        Mockito.`when`(mockCreator.viewType).thenReturn(1)
        val adapter = PagingHeterogeneousRecyclerViewAdapter(listOf(mockCreator))
        adapter.removeCreatorByViewType(1)
        assertEquals(0, adapter.itemCount)
    }

    @Test(expected = IllegalArgumentException::class)
    fun failIfViewTypeDoesNotExistWhileCreatingViewHolder() {
        val adapter = PagingHeterogeneousRecyclerViewAdapter()
        adapter.onCreateViewHolder(Mockito.mock(ViewGroup::class.java), 1)
    }
}