package com.example.gamereviewsapp.Presentation.Repository.Room;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.example.gamereviewsapp.Domain.Model.Game;
import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.Repository.RepositoryTasks;
import com.example.gamereviewsapp.Presentation.Repository.Room.DAO.ReviewDAO;

import java.util.List;

public class RoomRepository implements RepositoryTasks {
    private ReviewDAO reviewDAO;
    private LiveData<List<Review>> allReviews;

    public RoomRepository(Application application) {
        ReviewRoomDatabase database = ReviewRoomDatabase.getDatabase(application);
        reviewDAO = database.reviewDAO();
        allReviews = reviewDAO.getAllReviews();
    }


    public LiveData<List<Review>> getAllReviews() {
        return allReviews;
    }

    @Override
    public <T extends Review> void addReview(T review) {
        ReviewRoomDatabase.databaseWriteExecutor.execute(() -> {
            reviewDAO.addReview((Review) review);
        });
    }

    @Override
    public <T extends Review> void deleteReview(T review) {
        ReviewRoomDatabase.databaseWriteExecutor.execute(() -> {
            reviewDAO.deleteReview((Review) review);
        });
    }
}
