package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.Banner;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerViewHolder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.Category;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorViewHolder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorViewModel;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.Content;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewModel;

import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Toast toast;

    private ViewHolderModel[] viewHolderModels = new ViewHolderModel[]{new CategorySelectorViewModel(new Category("Blah")),
            new ContentSelectorViewModel(getContentViewModels()),
            new ContentSelectorViewModel(getContentViewModels()),
            new BannerViewModel(new Banner("foo")),
            new ContentSelectorViewModel(getContentViewModels()),
            new BannerViewModel(new Banner("bar"))};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.sample_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        SampleRecyclerViewAdapter adapter = new SampleRecyclerViewAdapter(getViewHolderCreators());
        adapter.setData(viewHolderModels);
        recyclerView.setAdapter(adapter);
    }

    private ContentViewModel[] getContentViewModels() {
        Random random = new Random();
        int randomSize = random.nextInt(100 - 3) + 3;

        ContentViewModel[] viewHolderModels = new ContentViewModel[randomSize];

        for (int i = 0; i < randomSize; i++) {
            viewHolderModels[i] = new ContentViewModel(new Content(RandomString.get(3, 10)));
        }

        return viewHolderModels;
    }

    private ViewHolderCreator[] getViewHolderCreators() {
        BannerCreator bannerCreator = new BannerCreator();
        bannerCreator.setClickListener(new BannerViewHolder.ClickListener() {
            @Override
            public void onClick(int position) {
                Banner banner = (Banner) viewHolderModels[position].emit();
                showMessage(String.format(Locale.getDefault(), "Banner @ position %d clicked: %s", position, banner.getText()));
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
            public void onItemClick(int parentPosition, int position) {
                ContentViewModel[] contentViewModel = (ContentViewModel[]) viewHolderModels[parentPosition].emit();
                Content content = (Content) contentViewModel[position].emit();
                showMessage(String.format(Locale.getDefault(), "Content @ position %d clicked: %s", position, content.getTitle()));
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
