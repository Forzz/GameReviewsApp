package com.example.gamereviewsapp.Domain.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "review_table")
public class Review {
    @PrimaryKey
    private int id;

    private String review;
    private int score;

    public Review(String review, int score) {
        this.review = review;
        this.score = score;
    }

    public int getId() {
        return id;
    }

    public String getReview() {
        return review;
    }

    public int getScore() {
        return score;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setScore(int score) {
        this.score = score;
    }
}
