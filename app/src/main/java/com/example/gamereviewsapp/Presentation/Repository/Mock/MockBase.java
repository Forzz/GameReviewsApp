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

        Review review1 = new Review("Deathloop", "Good game", 7, "file:///data/user/0/com.example.gamereviewsapp/app_Images/Deathloop.jpg");
        Review review2 = new Review("The Witcher 3: Wild Hunt", "One of the best", 9, "file:///data/user/0/com.example.gamereviewsapp/app_Images/TheWitcher3WildHunt.jpg");

        reviewsList.add(review1);
        reviewsList.add(review2);

        reviews = new MutableLiveData<>(reviewsList);

        gamesList = new ArrayList<>();

//        Game game1 = new Game(1, "Deathloop", "In Deathloop, the player takes on the role of Colt, an assassin stuck in a time loop who has been tasked to take out eight targets called Visionaries across the island before midnight.", 88, 4.7);
//        Game game2 = new Game(2, "The Witcher 3: Wild Hunt", "An action role-playing game with a third-person perspective. Players control Geralt of Rivia, a monster slayer known as a Witcher.", 92, 9.2);
//        Game game3 = new Game(3, "Heavy Rain", "It's a 2010 interactive drama action-adventure video game developed by Quantic Dream. The game features four protagonists involved with the mystery of the Origami Killer, a serial murderer who uses extended periods of rainfall to drown his victims.", 78, 7.9);
//        gamesList.add(game1);
//        gamesList.add(game2);
//        gamesList.add(game3);

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
        reviewsList.add(review);

        reviews.setValue(reviewsList);
    }

    @Override
    public <T extends Review> void deleteReview(T review) {
        reviewsList.remove(review);

        reviews.setValue(reviewsList);
    }
}
