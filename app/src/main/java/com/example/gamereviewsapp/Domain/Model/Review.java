package com.example.gamereviewsapp.Domain.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "review_table")
public class Review {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String parentTitle;
    private String review;
    private int score;
    private String imgUri;

    public Review(String parentTitle, String review, int score, String imgUri) {
        this.parentTitle = parentTitle;
        this.review = review;
        this.score = score;
        this.imgUri = imgUri;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParentTitle() {
        return parentTitle;
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

    public String getImgUri() {
        return imgUri;
    }

    public void setParentTitle(String parentTitle) {
        this.parentTitle = parentTitle;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public void setImgUri(String imgUri) {
        this.imgUri = imgUri;
    }
}
