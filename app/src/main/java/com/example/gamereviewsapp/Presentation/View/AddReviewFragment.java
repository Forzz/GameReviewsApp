package com.example.gamereviewsapp.Presentation.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamereviewsapp.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class AddReviewFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);

        return inflater.inflate(R.layout.fragment_add_review, container, false);
    }

    @Override
    public void onDestroy() {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);

        super.onDestroy();
    }
}