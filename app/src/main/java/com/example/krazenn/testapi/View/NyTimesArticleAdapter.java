package com.example.krazenn.testapi.View;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krazenn.testapi.Model.MostPopular.ResultMostPopular;
import com.example.krazenn.testapi.R;

import java.util.List;

public class NyTimesArticleAdapter extends RecyclerView.Adapter<NyTimesViewHolder> {

    // FOR DATA
    private List<ResultMostPopular> resultMostPopulars;

    // CONSTRUCTOR
    public NyTimesArticleAdapter(List<ResultMostPopular> resultMostPopulars) { this.resultMostPopulars = resultMostPopulars;
    }

    @Override
    public NyTimesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // CREATE VIEW HOLDER AND INFLATING ITS XML LAYOUT
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.fragment_main_item, parent, false);

        return new NyTimesViewHolder(view);
    }

    // UPDATE VIEW HOLDER WITH A ARTICLE
    @Override
    public void onBindViewHolder(NyTimesViewHolder viewHolder, int position) {
        viewHolder.updateWithArticle(this.resultMostPopulars.get(position));
    }

    // RETURN THE TOTAL COUNT OF ITEMS IN THE LIST
    @Override
    public int getItemCount() {
        return this.resultMostPopulars.size();
    }
}
