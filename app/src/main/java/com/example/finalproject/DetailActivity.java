package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public  static final String EXTRA_NAME = "extra_title";
    public  static final String EXTRA_IMAGES = "extra_images";
    public  static final String EXTRA_CATEGORY = "extra_category";
    public  static final String EXTRA_DESKRIPSI= "extra_deskripsi";

    int Click = 0;
    ImageView dimages;
    TextView dtitle;
    TextView dcategory;
    TextView ddeskripsi;
    Button downloadbtn;
    String category,title,deskripsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        dimages = findViewById(R.id.images);
        dtitle = findViewById(R.id.title);
        dcategory = findViewById(R.id.category);
        ddeskripsi = findViewById(R.id.deskripsi);
        downloadbtn = findViewById(R.id.button);
        downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        dimages = (ImageView) findViewById(R.id.images); // init a ImageView
        Intent intent = getIntent(); // get Intent which was set from adapter of Previous Activity
        dimages.setImageResource(intent.getIntExtra("cover", 0)); // get image from Intent and set it in ImageView
        String djudul = intent.getStringExtra("title");
        downloadbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (djudul.equals("Catatan Juang")) {
                    Uri uri = Uri.parse("https://bit.ly/3jMAqPA"); // Link Buku 1
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);
                } else if (djudul.equals("5 CM")) {
                    Uri uri = Uri.parse("https://bit.ly/3AxXck0"); // Link Buku 2
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                } else if (djudul.equals("1001 Jalan Bisnis Online ")) {
                    Uri uri = Uri.parse("https://bit.ly/3dKzIi1"); // Link Buku 1
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                } else if (djudul.equals("Kenali Agamamu ")) {
                    Uri uri = Uri.parse("https://bit.ly/3qNAKyS"); // Link Buku 4
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                } else if (djudul.equals("Kenali Agamamu ")) {
                    Uri uri = Uri.parse("https://bit.ly/36gMf8S"); // Link Buku 5
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                } else if (djudul.equals("Cara Dapat Panggilan Kerja ")) {
                    Uri uri = Uri.parse("https://bit.ly/3Apnx3X"); // Link Buku 6
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }else if (djudul.equals("Cara Dapat Panggilan Kerja ")) {
                    Uri uri = Uri.parse("https://bit.ly/3Apnx3X"); // Link Buku 6
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }else if (djudul.equals("Cara Dapat Panggilan Kerja ")) {
                    Uri uri = Uri.parse("https://bit.ly/3Apnx3X"); // Link Buku 6
                    Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                    startActivity(intent);

                }
            }
        });
        String title = getIntent().getStringExtra(EXTRA_NAME);
        String category = getIntent().getStringExtra(EXTRA_CATEGORY);
        String deskripsi = getIntent().getStringExtra(EXTRA_DESKRIPSI);
        int Url = getIntent().getIntExtra(EXTRA_IMAGES,0);

        Glide.with(dimages.getContext())
                .load(Url)
                .into(dimages);
        ddeskripsi.setText(deskripsi);
        dcategory.setText(category);
        dtitle.setText(title);
    }
}