package com.example.finalproject.fragment;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.finalproject.LoginActivity;
import com.example.finalproject.R;
import com.example.finalproject.SharedPrefManager;

import static androidx.core.app.ActivityCompat.finishAffinity;


public class ProfileFragment extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_profile, container, false);
        final SharedPrefManager sharedPrefManager = new SharedPrefManager(getContext());

        TextView username = view.findViewById(R.id.tvUsername);
        TextView password = view.findViewById(R.id.tvPassword);
        TextView logout = view.findViewById(R.id.tvLogout);


        username.setText(sharedPrefManager.getUsername());
        password.setText(sharedPrefManager.getPassword());

        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getActivity(), LoginActivity.class);
                sharedPrefManager.saveIsLogin(false);
                finishAffinity(getActivity());
                startActivity(i);
            }
        });
        return view;
    }
}
