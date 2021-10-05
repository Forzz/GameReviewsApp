package com.example.gamereviewsapp.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.Repository.Repository;

import java.util.List;

public class ReviewPreviewViewModel extends ViewModel {

    public LiveData<List<Review>> getReviewsList() {
        return Repository.getRepository().getAllReviews();
    }

    public void deleteReview(Review review) {
        Repository.getRepository().deleteReview(review);
    }
}
