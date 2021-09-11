package com.example.gamereviewsapp.Domain.Model;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class Review {
    @PrimaryKey
    private int id;

    private String review;
    private int score;
}
