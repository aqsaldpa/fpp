package com.example.finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.finalproject.fragment.BerandaFragment;
import com.example.finalproject.fragment.FavoritFragment;
import com.example.finalproject.fragment.ProfileFragment;
import com.ismaeldivita.chipnavigation.ChipNavigationBar;

import static android.content.ContentValues.TAG;

public class BottomNavActivity extends AppCompatActivity {
    ChipNavigationBar BottomNav;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_nav);
        BottomNav = findViewById(R.id.bottomBar);
        if (savedInstanceState == null) {
            BottomNav.setItemSelected(R.id.home, true);
            fragmentManager = getSupportFragmentManager();
            BerandaFragment berandaFragment = new BerandaFragment();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, berandaFragment)
                    .commit();
        }
        BottomNav.setOnItemSelectedListener(i -> {
            Fragment fragment = null;

            switch (i) {
                case R.id.item1:
                    fragment = new BerandaFragment();
                    break;

                case R.id.item3:
                    fragment = new FavoritFragment();
                    break;
                case R.id.item4:
                    fragment = new ProfileFragment();
                    break;

            }
            if (fragment != null) {
                fragmentManager = getSupportFragmentManager();
                fragmentManager.beginTransaction()
                        .replace(R.id.container, fragment)
                        .commit();

            } else {
                Log.e(TAG, "Error in creating fragment");
            }

        });
    }
}
