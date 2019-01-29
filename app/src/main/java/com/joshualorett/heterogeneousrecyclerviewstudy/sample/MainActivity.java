package com.joshualorett.heterogeneousrecyclerviewstudy.sample;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.widget.Toast;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.HeterogeneousRecyclerViewAdapter;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.lib.ViewHolderBinder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.Banner;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerViewHolder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.banner.BannerViewBinder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.Category;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector.CategorySelectorViewBinder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorCreator;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorViewHolder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.ContentSelectorViewBinder;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.Content;
import com.joshualorett.heterogeneousrecyclerviewstudy.sample.contentselector.content.ContentViewBinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private Toast toast;

    private List<ViewHolderBinder<?>> viewHolderBinders =
            Arrays.asList(new CategorySelectorViewBinder(new Category("Blah")),
                    new ContentSelectorViewBinder(getContentViewModels()),
                    new ContentSelectorViewBinder(getContentViewModels()),
                    new BannerViewBinder(new Banner("foo")),
                    new ContentSelectorViewBinder(getContentViewModels()),
                    new BannerViewBinder(new Banner("bar")));

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.sample_recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        HeterogeneousRecyclerViewAdapter adapter = new HeterogeneousRecyclerViewAdapter(getViewHolderCreators());
        adapter.setBinders(viewHolderBinders);
        recyclerView.setAdapter(adapter);
    }

    private List<ContentViewBinder> getContentViewModels() {
        Random random = new Random();
        int randomSize = random.nextInt(100 - 3) + 3;

        List<ContentViewBinder> viewHolderModels = new ArrayList<>(randomSize);
        for (int i = 0; i < randomSize; i++) {
            viewHolderModels.add(i, new ContentViewBinder(new Content(RandomString.get(3, 10))));
        }
        return viewHolderModels;
    }

    private List<ViewHolderCreator> getViewHolderCreators() {
        BannerCreator bannerCreator = new BannerCreator();
        bannerCreator.setClickListener(new BannerViewHolder.ClickListener() {
            @Override
            public void onClick(int position) {
                Banner banner = (Banner) viewHolderBinders.get(position).emit();
                showMessage(String.format(Locale.getDefault(), "Banner @ position %d clicked: %s", position, banner.getText()));
            }
        });

        final ContentSelectorCreator contentSelectorCreator = new ContentSelectorCreator();
        contentSelectorCreator.setHeaderActionClickListener(new ContentSelectorViewHolder.HeaderActionClickListener() {
            @Override
            public void onHeaderActionClick(int position) {
                showMessage(String.format(Locale.getDefault(), "Action header @ position %d clicked", position));
            }
        });
        contentSelectorCreator.setItemClickListener(new ContentSelectorViewHolder.ItemClickListener() {
            @Override
            public void onItemClick(int parentPosition, int position) {
                ContentSelectorViewBinder contentSelectorViewBinder = (ContentSelectorViewBinder) viewHolderBinders.get(parentPosition);
                Content content = contentSelectorViewBinder.emit().get(position).emit();
                showMessage(String.format(Locale.getDefault(), "Content @ position %d clicked: %s", position, content.getTitle()));
            }
        });

        return Arrays.asList(bannerCreator, new CategorySelectorCreator(), contentSelectorCreator);
    }

    private void showMessage(String message) {
        if(toast != null) {
            toast.cancel();
        }
        toast = Toast.makeText(this, message, Toast.LENGTH_SHORT);
        toast.show();
    }
}
