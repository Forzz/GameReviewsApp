package com.example.gamereviewsapp.Presentation.Repository.Mock;

import androidx.lifecycle.MutableLiveData;

import com.example.gamereviewsapp.Domain.Model.Review;

import java.util.ArrayList;
import java.util.List;

public class MockReviews {
    MutableLiveData<List<Review>> reviews;
    List<Review> reviewsList;

    public MutableLiveData<List<Review>> getReviews() {
        return reviews;
    }

    public MockReviews() {
        reviewsList = new ArrayList<>();

        Review review1 = new Review("Deathloop", "Good game", 7);
        Review review2 = new Review("The Witcher 3: Wild Hunt", "One of the best", 9);

        reviewsList.add(review1);
        reviewsList.add(review2);

        reviews = new MutableLiveData<>(reviewsList);
    }
}
