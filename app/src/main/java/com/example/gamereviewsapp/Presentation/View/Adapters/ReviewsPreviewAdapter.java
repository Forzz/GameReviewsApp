package com.example.gamereviewsapp.Presentation.View.Adapters;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.ViewModel.ReviewPreviewViewModel;
import com.example.gamereviewsapp.R;
import com.example.gamereviewsapp.databinding.ReviewPreviewItemBinding;

import java.util.ArrayList;
import java.util.List;

public class ReviewsPreviewAdapter extends RecyclerView.Adapter<ReviewsPreviewAdapter.ReviewPreviewViewHolder>{

    private List<Review> reviews;
    private ReviewPreviewViewModel reviewPreviewVM;

    public ReviewsPreviewAdapter(List<Review> reviews) {
        this.reviews = reviews;
    }

    @Override
    public ReviewPreviewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ReviewPreviewItemBinding rbinding = ReviewPreviewItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ReviewPreviewViewHolder(rbinding);
    }

    @Override
    public void onBindViewHolder(@NonNull ReviewPreviewViewHolder holder, int position) {
        String[] reviewData = new String[4];
        reviewData[0] = reviews.get(position).getReview();
        reviewData[1] = reviews.get(position).getParentTitle();
        reviewData[2] = String.valueOf(reviews.get(position).getScore());
        reviewData[3] = reviews.get(position).getImgUri();

        System.out.println(reviewData[3]);

        holder.binding.reviewPreviewItemTitle.setText(reviews.get(position).getParentTitle());
        holder.binding.reviewPreviewItemScore.setText(reviews.get(position).getScore() + " / 10");

        holder.itemView.setOnClickListener(view -> {
            Bundle bundle = new Bundle();
            bundle.putStringArray("reviewData", reviewData);
            Navigation.findNavController(view).navigate(R.id.reviewDetailFragment);
        });
    }

    @Override
    public int getItemCount() {
        return reviews.size();
    }

    public List<Review> getReviews() {
        return reviews;
    }

    class ReviewPreviewViewHolder extends RecyclerView.ViewHolder {

        ReviewPreviewItemBinding binding;

        public ReviewPreviewViewHolder(ReviewPreviewItemBinding binding) {
            super(binding.getRoot());

            this.binding = binding;
        }
    }
}
