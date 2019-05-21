package com.example.krazenn.testapi.View;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.example.krazenn.testapi.Model.ArticleList;
import com.example.krazenn.testapi.Model.MostPopular.ResultMostPopular;
import com.example.krazenn.testapi.R;

import java.util.List;


public class ArticleAdapter extends RecyclerView.Adapter<ArticleAdapter.ArticleViewHolder> {
    public List<ResultMostPopular> resultMostPopulars;

    public ArticleAdapter(List<ResultMostPopular> dataList) {
        this.resultMostPopulars = dataList;
    }

    @Override
    public ArticleViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.article_layout, parent, false);
        return new ArticleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ArticleViewHolder holder, int position) {
        holder.txtArtTitle.setText(resultMostPopulars.get(position).getTitle());
        holder.txtArtDescription.setText(resultMostPopulars.get(position).getUrl());
    }

    @Override
    public int getItemCount() {
        return resultMostPopulars.size();
    }

    class ArticleViewHolder extends RecyclerView.ViewHolder {

        TextView txtArtTitle, txtArtDescription;
        ImageView imgView;

        ArticleViewHolder(View itemView) {
            super(itemView);
            imgView = itemView.findViewById(R.id.img_article);
            txtArtTitle = itemView.findViewById(R.id.txt_article_title);
            txtArtDescription =  itemView.findViewById(R.id.txt_description_article);

        }
    }
}
