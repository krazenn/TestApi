package com.example.krazenn.testapi.Model.MostPopular;

import com.example.krazenn.testapi.Model.ArticleList;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ArticleL {
    @SerializedName(value = "article")
    public List<ArticleList> getArticleLists() {
        return articleLists;
    }

    public void setArticleLists(List<ArticleList> articleLists) {
        this.articleLists = articleLists;
    }

    @SerializedName("articles")
private List<ArticleList> articleLists = null;

}
