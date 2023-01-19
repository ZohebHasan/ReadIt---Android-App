package com.example.readit;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder> {

    Context context;
    ArrayList<ModelClass> modelClassList;


    public Adapter(Context context, ArrayList<ModelClass> modelClassList) {
        this.context = context;
        this.modelClassList = modelClassList;
    }

    @NonNull
    @Override
    public Adapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.news, null, false);
        return new ViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull Adapter.ViewHolder holder, @SuppressLint("RecyclerView") int position) { //had to suppress position

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, webView.class);
                intent.putExtra("url", modelClassList.get(position).getUrl());
                context.startActivity(intent);
            }
        });
        holder.time.setText("Published At: " + modelClassList.get(position).getPublishedAt());
        holder.author.setText(modelClassList.get(position).getAuthor());
        holder.heading.setText(modelClassList.get(position).getTitle());
        holder.content.setText(modelClassList.get(position).getDescription());
        Glide.with(context).load(modelClassList.get(position).getUrlToImage()).into(holder.imageview);

    }

    @Override
    public int getItemCount() {
        return modelClassList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView heading, content, author, time;
        CardView cardView;
        ImageView imageview;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            heading = itemView.findViewById(R.id.mainHeading);
            content = itemView.findViewById(R.id.content);
            author = itemView.findViewById(R.id.author);
            time = itemView.findViewById(R.id.time);
            imageview = itemView.findViewById(R.id.imageView);
            cardView = itemView.findViewById(R.id.cardView);


        }
    }
}
