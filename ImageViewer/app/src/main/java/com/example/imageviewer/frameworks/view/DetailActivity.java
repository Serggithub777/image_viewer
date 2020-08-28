package com.example.imageviewer.frameworks.view;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.imageviewer.R;
import com.example.imageviewer.entities.Hit;
import com.example.imageviewer.frameworks.network.GlideLoader;
import com.example.imageviewer.interface_adapters.presenters.DetailPresenter;

import java.util.List;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class DetailActivity extends MvpAppCompatActivity implements InterfDetailActivity {
    public static final String TAG = "DetailActivity";
    private GlideLoader glideLoader;
    private List<Hit> hits;
    private ImageView imageViewDetail;

    @InjectPresenter
    DetailPresenter presenterDetail;

    @ProvidePresenter
    public DetailPresenter providePresenter() {
        return new DetailPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        imageViewDetail = findViewById(R.id.imageViewDetail);
        glideLoader = new GlideLoader(getApplicationContext());
        Intent intent = getIntent();
        int position = intent.getIntExtra("position", -1);
        presenterDetail.getUrlByPosition(position);
        Toast.makeText(this, String.format("Позиция - %d", position), Toast.LENGTH_SHORT).show();
    }

    @Override
    public void setImage(String url) {
        Log.d(TAG, "setImage" + url);
        glideLoader.loadImage(url,imageViewDetail);
    }
}
