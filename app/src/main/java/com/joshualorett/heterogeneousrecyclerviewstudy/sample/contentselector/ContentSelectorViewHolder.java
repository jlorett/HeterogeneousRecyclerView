package com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;

/**
 * Created by Joshua on 11/21/2016.
 */

public class ContentSelectorViewHolder extends RecyclerView.ViewHolder {
    private HeaderActionClickListener actionClickListener;

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
    }

    public void setHeaderActionClickListener(HeaderActionClickListener listener) {
        actionClickListener = listener;
    }

    public interface HeaderActionClickListener {
        void onHeaderActionClick(int position);
    }
}
