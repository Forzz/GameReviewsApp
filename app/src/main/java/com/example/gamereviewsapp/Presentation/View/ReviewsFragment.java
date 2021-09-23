package com.example.gamereviewsapp.Presentation.View;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.View.Adapters.GamesListAdapter;
import com.example.gamereviewsapp.Presentation.View.Adapters.ReviewsPreviewAdapter;
import com.example.gamereviewsapp.Presentation.ViewModel.ReviewPreviewViewModel;
import com.example.gamereviewsapp.R;
import com.example.gamereviewsapp.databinding.FragmentReviewsBinding;
import com.example.gamereviewsapp.databinding.ReviewPreviewItemBinding;

import java.util.List;

public class ReviewsFragment extends Fragment {

    private ReviewPreviewViewModel reviewPreviewVM;
    private FragmentReviewsBinding binding;

    public ReviewsFragment() {}

    public static ReviewsFragment newInstance() {
        return new ReviewsFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        binding = FragmentReviewsBinding.inflate(getLayoutInflater(), container, false);
        binding.reviewPreviewsRecycler.setLayoutManager(new LinearLayoutManager(getContext()));

        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder,
                                  @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                reviewPreviewVM.deleteReview(((ReviewsPreviewAdapter)
                        binding.reviewPreviewsRecycler.getAdapter()).getReviews().get(position));
            }
        }).attachToRecyclerView(binding.reviewPreviewsRecycler);

        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        reviewPreviewVM = new ViewModelProvider(this).get(ReviewPreviewViewModel.class);
        reviewPreviewVM.getReviewsList().observe(getViewLifecycleOwner(), (List<Review> reviewList) -> {
            binding.reviewPreviewsRecycler.setAdapter(new ReviewsPreviewAdapter(reviewList));
        });
    }
}