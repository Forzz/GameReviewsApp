package com.example.gamereviewsapp.Presentation.Repository.Mock;

import androidx.lifecycle.MutableLiveData;

import com.example.gamereviewsapp.Domain.Model.Game;
import com.example.gamereviewsapp.Domain.Model.Review;
import com.example.gamereviewsapp.Presentation.Repository.RepositoryTasks;

import java.util.ArrayList;
import java.util.List;

public class MockBase implements RepositoryTasks {
    MutableLiveData<List<Review>> reviews;
    List<Review> reviewsList;

    MutableLiveData<List<Game>> games;
    List<Game> gamesList;

    public MutableLiveData<List<Review>> getReviews() {
        return reviews;
    }

    public MockBase() {
        reviewsList = new ArrayList<>();

        Review review1 = new Review("Deathloop", "Good game", 7);
        Review review2 = new Review("The Witcher 3: Wild Hunt", "One of the best", 9);

        reviewsList.add(review1);
        reviewsList.add(review2);

        reviews = new MutableLiveData<>(reviewsList);

        gamesList = new ArrayList<>();

        Game game1 = new Game(1, "Deathloop", "In Deathloop, the player takes on the role of Colt, an assassin stuck in a time loop who has been tasked to take out eight targets called Visionaries across the island before midnight.", 88, 4.7);
        Game game2 = new Game(2, "The Witcher 3: Wild Hunt", "An action role-playing game with a third-person perspective. Players control Geralt of Rivia, a monster slayer known as a Witcher.", 92, 9.2);
        gamesList.add(game1);
        gamesList.add(game2);

        games = new MutableLiveData<>(gamesList);
    }

    public <T extends Game> MutableLiveData<List<Game>> getAllGames() {
        return games;
    }

    @Override
    public <T extends Review> MutableLiveData<List<Review>> getAllReviews() {
        return reviews;
    }

    @Override
    public <T extends Review> void addReview(T review) {

    }

    @Override
    public <T extends Review> void deleteReview(T review) {

    }
}
