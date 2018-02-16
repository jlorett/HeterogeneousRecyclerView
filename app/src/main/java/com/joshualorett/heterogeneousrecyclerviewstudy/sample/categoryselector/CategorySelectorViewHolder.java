package com.joshualorett.heterogeneousrecyclerviewstudy.sample.categoryselector;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;

import com.joshualorett.heterogeneousrecyclerviewstudy.R;

/**
 * ViewHolder for category selector.
 * Created by Joshua on 11/20/2016.
 */

public class CategorySelectorViewHolder extends RecyclerView.ViewHolder {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;

    public CategorySelectorViewHolder(View itemView) {
        super(itemView);

        one = (Button) itemView.findViewById(R.id.button_one);
        two = (Button) itemView.findViewById(R.id.button_two);
        three = (Button) itemView.findViewById(R.id.button_three);
        four = (Button) itemView.findViewById(R.id.button_four);
        five = (Button) itemView.findViewById(R.id.button_five);
        six = (Button) itemView.findViewById(R.id.button_six);
    }

    public void setButtonText(String textOne, String textTwo, String textThree, String textFour,
                              String textFive, String textSix) {
        one.setText(textOne);
        two.setText(textTwo);
        three.setText(textThree);
        four.setText(textFour);
        five.setText(textFive);
        six.setText(textSix);
    }
}
