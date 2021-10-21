package com.example.gamereviewsapp.Domain.Model;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;

public class Game {

    final private int id;
    private String title;
//    private Bitmap previewImage;
    int criticsScore;
    double usersScore;

    public Game(int id, String title, int criticsScore, double usersScore) {
        this.id = id;
        this.title = title;
        this.criticsScore = criticsScore;
        this.usersScore = usersScore;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public int getCriticsScore() {
        return criticsScore;
    }

    public double getUsersScore() {
        return usersScore;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCriticsScore(int criticsScore) {
        this.criticsScore = criticsScore;
    }

    public void setUsersScore(double usersScore) {
        this.usersScore = usersScore;
    }
}
