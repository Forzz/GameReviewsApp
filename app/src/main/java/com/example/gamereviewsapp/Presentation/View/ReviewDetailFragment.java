package com.example.gamereviewsapp.Presentation.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamereviewsapp.Presentation.ViewModel.ReviewDetailViewModel;
import com.example.gamereviewsapp.R;
import com.example.gamereviewsapp.databinding.FragmentReviewDetailBinding;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.io.FileNotFoundException;

public class ReviewDetailFragment extends Fragment {

    ReviewDetailViewModel rdViewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rdViewModel = new ViewModelProvider(this).get(ReviewDetailViewModel.class);

        String[] reviewData = getArguments().getStringArray("reviewData");

        FragmentReviewDetailBinding binding = FragmentReviewDetailBinding.inflate(getLayoutInflater(), container, false);

        binding.reviewDetailTitle.setText(reviewData[1]);
        binding.reviewDetailText.setText(reviewData[0]);
        binding.reviewDetailScore.setText(reviewData[2] + " / 10");
        try {
            binding.reviewDetailImage.setImageBitmap(rdViewModel.getImage(requireActivity(), reviewData[3]));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.GONE);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    public void onDestroy() {
        BottomNavigationView navBar = getActivity().findViewById(R.id.bottomNavigationView);
        navBar.setVisibility(View.VISIBLE);

        super.onDestroy();
    }
}