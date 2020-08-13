package com.example.imageviewer.frameworks.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.imageviewer.R;

public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
