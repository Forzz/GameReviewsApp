package com.example.gamereviewsapp.Presentation.View.Adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.ViewModel.ReviewPreviewViewModel;
import com.example.gamereviewsapp.databinding.ReviewPreviewItemBinding;

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

        holder.binding.reviewPreviewItemTitle.setText(reviews.get(position).getParentTitle());
        holder.binding.reviewPreviewItemScore.setText(reviews.get(position).getScore() + " / 10");

//        holder.binding.deleteImageView.setOnClickListener(view -> {
//            reviewPreviewVM.deleteReview((holder.binding.).getReviews().get(position));
//        });
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
