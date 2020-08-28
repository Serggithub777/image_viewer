package com.example.imageviewer;

import android.app.Application;

import androidx.room.Room;

import com.example.imageviewer.frameworks.data_base.AppDatabase;

public class App extends Application {
    private static AppDatabase appDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        appDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class,
                "image_viewer_database").build();
    }
    public static AppDatabase getAppDatabase() {
        return appDatabase;
    }
}
