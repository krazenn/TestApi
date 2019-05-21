package com.example.krazenn.testapi.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.krazenn.testapi.Model.MostPopular.ResultMostPopular;
import com.example.krazenn.testapi.R;
import com.example.krazenn.testapi.Utils.NyStreams;
import com.example.krazenn.testapi.View.NyTimesArticleAdapter;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;

public class MainFragment extends Fragment {

    // FOR DESIGN
    @BindView(R.id.fragment_main_recycler_view)
    RecyclerView recyclerView; // 1 - Declare RecyclerView

    //FOR DATA
    private Disposable disposable;
    // 2 - Declare list of article (ResultMostPopular) & Adapter
    private List<ResultMostPopular> resultMostPopulars;
    private NyTimesArticleAdapter adapter;

    public MainFragment() { }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        ButterKnife.bind(this, view);
        this.configureRecyclerView(); // - 4 Call during UI creation
        this.executeHttpRequestWithRetrofit(); // 5 - Execute stream after UI creation
        return view;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.disposeWhenDestroy();
    }

    // -----------------
    // CONFIGURATION
    // -----------------

    // 3 - Configure RecyclerView, Adapter, LayoutManager & glue it together
    private void configureRecyclerView(){
        // 3.1 - Reset list
        this.resultMostPopulars = new ArrayList<>();
        // 3.2 - Create adapter passing the list of users
        this.adapter = new NyTimesArticleAdapter(this.resultMostPopulars);
        // 3.3 - Attach the adapter to the recyclerview to populate items
        this.recyclerView.setAdapter(this.adapter);
        // 3.4 - Set layout manager to position the items
        this.recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    // -------------------
    // HTTP (RxJAVA)
    // -------------------

    private void executeHttpRequestWithRetrofit(){
        this.disposable = NyStreams.streamFetchArticle(7).subscribeWith(new DisposableObserver<List<ResultMostPopular>>() {
            @Override
            public void onNext(List<ResultMostPopular> article) {
                // 6 - Update RecyclerView after getting results from NyTimes API
                updateUI(article);
            }

            @Override
            public void onError(Throwable e) { }

            @Override
            public void onComplete() { }
        });
    }

    private void disposeWhenDestroy(){
        if (this.disposable != null && !this.disposable.isDisposed()) this.disposable.dispose();
    }

    // -------------------
    // UPDATE UI
    // -------------------

    private void updateUI(List<ResultMostPopular> resultMostPopular){
        resultMostPopulars.addAll(resultMostPopular);
        adapter.notifyDataSetChanged();
    }
}

