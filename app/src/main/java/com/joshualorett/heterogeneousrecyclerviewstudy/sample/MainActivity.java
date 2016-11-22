package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorViewModel;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        SampleRecyclerViewAdapter adapter = new SampleRecyclerViewAdapter();
        adapter.setData(getViewModels());
        recyclerView.setAdapter(adapter);
    }

    private ViewHolderModel[] getViewModels() {
        return new ViewHolderModel[]{new CategorySelectorViewModel(),
                new ContentSelectorViewModel(),
                new ContentSelectorViewModel(),
                new BannerViewModel(),
                new ContentSelectorViewModel()};
    }
}
