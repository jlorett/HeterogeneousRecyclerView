package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.HeterogeneousRecyclerViewAdapter;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewBinder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewHolder;

import java.util.Collections;
import java.util.List;

/**
 * ViewHolder for content selector.
 * Created by Joshua on 11/21/2016.
 */

public class ContentSelectorViewHolder extends RecyclerView.ViewHolder {
    private HeaderActionClickListener actionClickListener;

    private ItemClickListener itemClickListener;

    private RecyclerView recyclerView;

    public ContentSelectorViewHolder(View itemView) {
        super(itemView);

        Button headerAction = (Button) itemView.findViewById(R.id.content_header_action);
        headerAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(actionClickListener != null) {
                    actionClickListener.onHeaderActionClick(getAdapterPosition());
                }
            }
        });

        recyclerView = (RecyclerView) itemView.findViewById(R.id.content_recycler_view);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext(), LinearLayoutManager.HORIZONTAL, false));
        HeterogeneousRecyclerViewAdapter adapter = new HeterogeneousRecyclerViewAdapter(getCreators());
        recyclerView.setAdapter(adapter);
    }

    private List<? extends ViewHolderCreator> getCreators() {
        ContentCreator contentCreator = new ContentCreator();
        contentCreator.setContentClickListener(new ContentViewHolder.ContentClickListener() {
            @Override
            public void onContentClick(int position) {
                if(itemClickListener != null) {
                    itemClickListener.onItemClick(getAdapterPosition(), position);
                }
            }
        });
        return Collections.singletonList(contentCreator);
    }

    public void setData(List<ContentViewBinder> viewHolderBinders) {
        HeterogeneousRecyclerViewAdapter adapter = (HeterogeneousRecyclerViewAdapter) recyclerView.getAdapter();
        if(adapter != null) {
            adapter.setBinders(viewHolderBinders);
            adapter.notifyDataSetChanged();
        }
    }

    public void setHeaderActionClickListener(HeaderActionClickListener listener) {
        actionClickListener = listener;
    }

    public void setItemClickListener(ItemClickListener listener) {
        itemClickListener = listener;
    }

    public interface HeaderActionClickListener {
        void onHeaderActionClick(int position);
    }

    public interface ItemClickListener {
        void onItemClick(int parentPosition, int position);
    }
}
