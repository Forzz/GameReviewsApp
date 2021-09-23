package com.example.gamereviewsapp.Presentation.ViewModel;

import androidx.lifecycle.ViewModel;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.Repository.Repository;

public class AddReviewViewModel extends ViewModel {
    public void addReview(String gameTitle, String reviewText, int score) {
        Review review = new Review(gameTitle, reviewText, score);

        Repository.getRepository().addReview(review);
    }

    public void deleteReview(String gameTitle, String reviewText, int score) {
        Review review = new Review(gameTitle, reviewText, score);

        Repository.getRepository().deleteReview(review);
    }
}
