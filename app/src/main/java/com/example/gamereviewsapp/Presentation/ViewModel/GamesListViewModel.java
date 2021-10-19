package com.example.gamereviewsapp.Presentation.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import com.example.gamereviewsapp.Domain.Model.Game;
import com.example.gamereviewsapp.Presentation.Repository.Api.RAWGApiProvider;
import com.example.gamereviewsapp.Presentation.Repository.Mock.MockBase;

import java.util.List;

public class GamesListViewModel extends ViewModel {

    public LiveData<List<Game>> getGamesList() {
        RAWGApiProvider rawgApiProvider = new RAWGApiProvider();
        return new MockBase().getAllGames();
    }
}
