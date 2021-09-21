package com.example.gamereviewsapp.Presentation.ViewModel;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.Repository.Repository;

public class AddReviewViewModel {
    public void addReview(String gameTitle, String reviewText, int score) {
        Review review = new Review(gameTitle, reviewText, score);

        Repository.getRepository().addReview(review);
    }
}
