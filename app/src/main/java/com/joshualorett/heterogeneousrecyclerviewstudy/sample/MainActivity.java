package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerViewHolder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorViewHolder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewModel;

import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SampleRecyclerViewAdapter adapter = new SampleRecyclerViewAdapter(getViewHolderCreators());
        adapter.setData(getViewModels());
        recyclerView.setAdapter(adapter);
    }

    private ViewHolderModel[] getViewModels() {
        return new ViewHolderModel[]{new CategorySelectorViewModel(),
                new ContentSelectorViewModel(getContentViewModels()),
                new ContentSelectorViewModel(getContentViewModels()),
                new BannerViewModel(),
                new ContentSelectorViewModel(getContentViewModels()),
                new BannerViewModel()};
    }

    private ViewHolderModel[] getContentViewModels() {
        Random random = new Random();
        int randomSize = random.nextInt(100 - 3) + 3;

        ViewHolderModel[] viewHolderModels = new ViewHolderModel[randomSize];

        for (int i = 0; i < randomSize; i++) {
            viewHolderModels[i] = new ContentViewModel();
        }

        return viewHolderModels;
    }

    private ViewHolderCreator[] getViewHolderCreators() {
        BannerCreator bannerCreator = new BannerCreator();
        bannerCreator.setClickListener(new BannerViewHolder.ClickListener() {
            @Override
            public void onClick(int position) {
                showMessage(String.format(Locale.getDefault(), "Banner @ position %d clicked", position));
            }
        });

        ContentSelectorCreator contentSelectorCreator = new ContentSelectorCreator();
        contentSelectorCreator.setHeaderActionClickListener(new ContentSelectorViewHolder.HeaderActionClickListener() {
            @Override
            public void onHeaderActionClick(int position) {
                showMessage(String.format(Locale.getDefault(), "Action header @ position %d clicked", position));
            }
        });
        contentSelectorCreator.setItemClickListener(new ContentSelectorViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(int position) {
                showMessage(String.format(Locale.getDefault(), "Content @ position %d clicked", position));
            }
        });

        return new ViewHolderCreator[]{bannerCreator,
                new CategorySelectorCreator(), contentSelectorCreator};
    }

    private void showMessage(String message) {
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
