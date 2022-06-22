package com.btech.recycleview;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.pkmmte.pkrss.Article;

import java.util.List;

public class RecycleAdapter extends RecyclerView.Adapter<ViewHolder> {

    public List<Article> list;

    public RecycleAdapter(List<Article> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Article article = list.get(position);

        holder.title.setText(article.getTitle());
        holder.desc.setText(article.getAuthor());

        new DownloadImageTask(holder.featuredImage).execute(article.getEnclosure().getUrl());

        holder.btnLink.setOnClickListener(view ->
                holder.itemView.getContext().startActivity(new Intent(Intent.ACTION_VIEW, article.getSource())));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
