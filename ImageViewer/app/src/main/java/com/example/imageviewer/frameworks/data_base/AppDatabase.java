package com.example.imageviewer.frameworks.data_base;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.imageviewer.entities.Hit;

@Database(entities = {Hit.class},version = 1,exportSchema = false)
public abstract class AppDatabase extends RoomDatabase {
    public abstract HitDao hitDao();
}
