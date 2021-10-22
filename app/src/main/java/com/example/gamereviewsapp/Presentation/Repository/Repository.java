package com.example.gamereviewsapp.Presentation.Repository;

import android.app.Application;

import com.example.gamereviewsapp.Presentation.Repository.Api.RAWGApi;
import com.example.gamereviewsapp.Presentation.Repository.Api.RAWGApiProvider;
import com.example.gamereviewsapp.Presentation.Repository.Mock.MockBase;
import com.example.gamereviewsapp.Presentation.Repository.Room.RoomRepository;

public class Repository {
    private static RepositoryTasks repository;
    private static RAWGApiProvider rawgApiProvider;

    static public void init(Application application) {
        if (repository == null) {
            repository = new RoomRepository(application);
        }
    }

    static public RepositoryTasks getRepository() {
        if (repository == null) {
            repository = new MockBase();
        }
        return repository;
    }

    static public RAWGApiProvider getRawgApiProvider() {
        if (rawgApiProvider == null) {
            rawgApiProvider = new RAWGApiProvider();
        }
        return rawgApiProvider;
    }
}
