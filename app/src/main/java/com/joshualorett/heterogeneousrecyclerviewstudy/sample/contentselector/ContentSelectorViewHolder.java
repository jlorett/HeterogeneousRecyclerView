package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.SampleRecyclerViewAdapter;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewHolder;

/**
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
        SampleRecyclerViewAdapter adapter = new SampleRecyclerViewAdapter(getCreators());
        recyclerView.setAdapter(adapter);
    }

    private ViewHolderCreator[] getCreators() {
        ContentCreator contentCreator = new ContentCreator();
        contentCreator.setContentClickListener(new ContentViewHolder.ContentClickListener() {
            @Override
            public void onContentClick(int position) {
                if(itemClickListener != null) {
                    itemClickListener.onItemClick(position);
                }
            }
        });
        return new ViewHolderCreator[]{contentCreator};
    }

    public void setData(ViewHolderModel[] viewHolderModels) {
        SampleRecyclerViewAdapter adapter = (SampleRecyclerViewAdapter) recyclerView.getAdapter();
        adapter.setData(viewHolderModels);
        adapter.notifyDataSetChanged();
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
        void onItemClick(int position);
    }
}
