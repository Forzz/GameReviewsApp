package com.example.gamereviewsapp.Presentation.Repository;

import android.app.Application;

import com.example.gamereviewsapp.Presentation.Repository.Mock.MockBase;
import com.example.gamereviewsapp.Presentation.Repository.Room.RoomRepository;

public class Repository {
    static RepositoryTasks repository;

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
}
