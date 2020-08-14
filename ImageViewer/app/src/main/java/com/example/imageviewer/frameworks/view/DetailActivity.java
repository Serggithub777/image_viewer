package com.example.imageviewer.frameworks.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imageviewer.R;
import com.example.imageviewer.entities.Hit;
import com.example.imageviewer.entities.Photo;
import com.example.imageviewer.frameworks.network.GlideLoader;

import java.util.List;

public class DetailActivity extends AppCompatActivity {
    public static final String TAG = "DetailActivity";
    private GlideLoader glideLoader;
    private List<Hit> hits;
    private ImageView imageViewDetail;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageViewDetail = findViewById(R.id.imageViewDetail);
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);
        Toast.makeText(this, String.format("Позиция - %d", position), Toast.LENGTH_SHORT).show();
        //String url = hits.get(position).webformatURL;
    }
}
