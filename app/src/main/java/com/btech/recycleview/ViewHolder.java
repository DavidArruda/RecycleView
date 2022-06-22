package com.btech.recycleview;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatButton;
import androidx.recyclerview.widget.RecyclerView;

public class ViewHolder extends RecyclerView.ViewHolder {

    public ImageView featuredImage;
    public TextView title, desc;
    public AppCompatButton btnLink;


    public ViewHolder(@NonNull View itemView) {
        super(itemView);

        this.featuredImage = itemView.findViewById(R.id.featuredImage);
        this.title = itemView.findViewById(R.id.title);
        this.desc = itemView.findViewById(R.id.desc);
        this.btnLink = itemView.findViewById(R.id.btnLink);

    }
}
