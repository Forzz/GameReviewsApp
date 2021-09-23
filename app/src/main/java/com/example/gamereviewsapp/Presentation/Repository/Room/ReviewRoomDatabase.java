package com.example.gamereviewsapp.Presentation.Repository.Room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.Repository.Room.DAO.ReviewDAO;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Database(entities = {Review.class}, version = 1, exportSchema = false)
public abstract class ReviewRoomDatabase extends RoomDatabase {
    public abstract ReviewDAO reviewDAO();

    private static volatile ReviewRoomDatabase INSTANCE;
    private static final int NUMBER_OF_THREADS = 4;
    static final ExecutorService databaseWriteExecutor = Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static ReviewRoomDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ReviewRoomDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(), ReviewRoomDatabase.class,
                            "GameReviewsDB").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
