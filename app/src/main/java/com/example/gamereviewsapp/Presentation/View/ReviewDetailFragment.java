package com.example.gamereviewsapp.Presentation.View;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamereviewsapp.R;
import com.example.gamereviewsapp.databinding.FragmentReviewDetailBinding;
import com.example.gamereviewsapp.databinding.GameItemBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class ReviewDetailFragment extends Fragment {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        String[] reviewData = getArguments().getStringArray("reviewData");

        FragmentReviewDetailBinding binding = FragmentReviewDetailBinding.inflate(getLayoutInflater());

        binding.reviewDetailTitle.setText(reviewData[0]);

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);

        return inflater.inflate(R.layout.fragment_review_detail, container, false);
    }

    public void onDestroy() {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);

        super.onDestroy();
    }
}