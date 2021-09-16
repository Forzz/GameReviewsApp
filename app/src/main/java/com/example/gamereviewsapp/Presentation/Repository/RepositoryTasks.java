package com.example.gamereviewsapp.Presentation.Repository;

import androidx.lifecycle.LiveData;

import com.example.gamereviewsapp.Domain.Model.Game;

import java.util.List;

public interface RepositoryTasks {
    <T extends Game>LiveData<List<T>> getAllGames();
}
