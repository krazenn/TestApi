package com.example.krazenn.testapi.Utils;


import com.example.krazenn.testapi.Model.ArticleList;
import com.example.krazenn.testapi.Model.MostPopular.ArticleL;
import com.example.krazenn.testapi.Model.MostPopular.ResultMostPopular;

import java.util.List;

import io.reactivex.Observable;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NyTimesService {


    String API_KEY = "api-key=hKPJScQIKlhcQ3V0GmlDulzquyM28AGL";

        @GET("svc/mostpopular/v2/viewed/{period}.json?api-key=hKPJScQIKlhcQ3V0GmlDulzquyM28AGL")
        Observable<List<ResultMostPopular>> getArticleMostPopular(@Path("period") int period);

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://api.nytimes.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build();


}
