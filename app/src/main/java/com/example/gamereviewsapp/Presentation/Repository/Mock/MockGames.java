package com.example.gamereviewsapp.Presentation.Repository.Mock;

import androidx.lifecycle.MutableLiveData;

import com.example.gamereviewsapp.Domain.Model.Game;

import java.util.ArrayList;
import java.util.List;

public class MockGames {
    MutableLiveData<List<Game>> games;
    List<Game> gamesList;

    public MutableLiveData<List<Game>> getAllGames() {
        return games;
    }

    public MockGames() {
        gamesList = new ArrayList<>();

        Game game1 = new Game(1, "Deathloop", "In Deathloop, the player takes on the role of Colt, an assassin stuck in a time loop who has been tasked to take out eight targets called Visionaries across the island before midnight.", 88, 4.7);
        Game game2 = new Game(2, "The Witcher 3: Wild Hunt", "is an action role-playing game with a third-person perspective. Players control Geralt of Rivia, a monster slayer known as a Witcher.", 92, 9.2);
        gamesList.add(game1);
        gamesList.add(game2);

        games = new MutableLiveData<>(gamesList);
    }
}
