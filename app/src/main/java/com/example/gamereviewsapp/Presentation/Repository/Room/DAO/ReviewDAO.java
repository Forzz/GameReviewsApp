package com.example.gamereviewsapp.Presentation.Repository.Room.DAO;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;

import com.example.gamereviewsapp.Domain.Model.Review;

import java.util.List;

@Dao
public interface ReviewDAO {

    @Insert
    void addReview(Review review);

    @Delete
    void deleteReview(Review review);

    @Query("SELECT * FROM review_table")
    LiveData<List<Review>> getAllReviews();
}
