package com.example.gamereviewsapp.Presentation.Repository;

import androidx.lifecycle.LiveData;

import com.example.gamereviewsapp.Domain.Model.Review;

import java.util.List;

public interface RepositoryTasks {
    <T extends Review> LiveData<List<Review>> getAllReviews();

    <T extends Review> void addReview(T review);

    <T extends Review> void deleteReview(T review);
}
