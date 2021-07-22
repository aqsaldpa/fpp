package com.example.finalproject;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ListViewHolder>{
    private final ArrayList<Book> books;
    private Context context;
    private OnItemClickCallback onItemClickCallback;


    public RecyclerViewAdapter(ArrayList<Book> list) {
        this.books= list;

    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.cardview_item_book, viewGroup, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        Book book = books.get(position);
        Glide.with(holder.itemView.getContext())
                .load(book.getImages())
                .apply(new RequestOptions())
                .into(holder.bookimg);
        holder.title.setText(book.getTitle());
//        holder.jarak.setText(planet.getJarak());
//        holder.deskripsi.setText(planet.getDetail());

        final Context mContext = holder.itemView.getContext();

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onItemClickCallback.onItemClicked(books.get(holder.getAdapterPosition()));

            }
        });
    }

    @Override
    public int getItemCount() {
        return books.size();
    }



    static class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView bookimg;
        TextView title,category,deskripsi;
        ListViewHolder(@NonNull View itemView) {
            super(itemView);

            bookimg = itemView.findViewById(R.id.bookimg);
            title = itemView.findViewById(R.id.booktitle);

        }
    }

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public interface OnItemClickCallback {
        void onItemClicked(Book data);
    }

}
