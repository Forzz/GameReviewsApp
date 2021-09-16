package com.example.gamereviewsapp.Domain.Model;

public class Game {

    final private int id;
    private String title;
    private String description;
    int criticsScore;
    double usersScore;

    public Game(int id, String title, String description, int criticsScore, double usersScore) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.criticsScore = criticsScore;
        this.usersScore = usersScore;
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
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

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCriticsScore(int criticsScore) {
        this.criticsScore = criticsScore;
    }

    public void setUsersScore(double usersScore) {
        this.usersScore = usersScore;
    }
}
