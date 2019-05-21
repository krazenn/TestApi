package com.example.krazenn.testapi.View;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.krazenn.testapi.Model.MostPopular.ResultMostPopular;
import com.example.krazenn.testapi.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NyTimesViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.fragment_main_item_title)
    TextView textView;

    public NyTimesViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this, itemView);
    }

    public void updateWithArticle(ResultMostPopular resultMostPopular){
        this.textView.setText(resultMostPopular.getTitle());
    }
}
