package com.btech.recycleview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.pkmmte.pkrss.Article;
import com.pkmmte.pkrss.Callback;
import com.pkmmte.pkrss.PkRSS;

import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Callback {

    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private List<Article> list = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recycleView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recycleAdapter = new RecycleAdapter(list);
        recyclerView.setAdapter(recycleAdapter);

        PkRSS.with(this).load("http://www.androidpro.com.br/feed/").skipCache().callback(this).async();
    }

    @Override
    public void onPreload() {

    }

    @Override
    public void onLoaded(List<Article> newArticles) {
        list.clear();
        list.addAll(newArticles);
        recycleAdapter.notifyDataSetChanged();
    }

    @Override
    public void onLoadFailed() {

    }
}