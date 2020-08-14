package com.example.imageviewer.frameworks.view;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.imageviewer.R;
import com.example.imageviewer.interface_adapters.adapters.MainAdapter;
import com.example.imageviewer.interface_adapters.presenters.MainPresenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class MainActivity extends MvpAppCompatActivity implements MainView {
    private static final String TAG = "MainActivity";

    private MainAdapter mainAdapter;

    @BindView(R.id.recycler_view_activity_main)
    RecyclerView recyclerView;

    @InjectPresenter
    MainPresenter presenter;

    @ProvidePresenter
    public MainPresenter providePresenter() {
        return new MainPresenter();
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        initRecyclerView();
    }

    private void initRecyclerView(){

        GridLayoutManager layoutManager = new GridLayoutManager(this, 2);
        recyclerView.setLayoutManager(layoutManager);
        mainAdapter = new MainAdapter(this, presenter.getRecyclerMain());
        recyclerView.setAdapter(mainAdapter);
    }


    @Override
    public void updateRecyclerView() {
        mainAdapter.notifyDataSetChanged();
    }
}
