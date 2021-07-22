package com.example.finalproject.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.example.finalproject.Book;
import com.example.finalproject.BookData;
import com.example.finalproject.DetailActivity;
import com.example.finalproject.R;
import com.example.finalproject.RecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;


public class BerandaFragment extends Fragment {

    private RecyclerView rvBook;
    private ArrayList<Book> list = new ArrayList<>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_beranda, container, false);
        rvBook = view.findViewById(R.id.rv);
        rvBook.setHasFixedSize(true);
//        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
//        rvBook.setLayoutManager(mLayoutManager);
        list.addAll(BookData.getListData());
        showRecyclerList();
        return view;

    }

    private void showRecyclerList() {
        RecyclerView.LayoutManager mLayoutManager = new GridLayoutManager(getContext(), 2);
        rvBook.setLayoutManager(mLayoutManager);
        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(list);
        rvBook.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnItemClickCallback(new RecyclerViewAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Book data) {

                showSelectedBook(data);
            }

            private void showSelectedBook(Book data) {
                Toast.makeText(getContext(), "You Selected " + data.getTitle(), Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(getActivity(), DetailActivity.class);
                intent.putExtra(DetailActivity.EXTRA_NAME, data.getTitle());
                intent.putExtra(DetailActivity.EXTRA_DESKRIPSI, data.getDeskripsi());
                intent.putExtra(DetailActivity.EXTRA_CATEGORY, data.getCategory());
                intent.putExtra(DetailActivity.EXTRA_IMAGES, data.getImages());
                startActivity(intent);
            }
        });
    }

}