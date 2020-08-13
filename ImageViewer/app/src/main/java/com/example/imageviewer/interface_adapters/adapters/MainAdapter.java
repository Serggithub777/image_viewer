package com.example.imageviewer.interface_adapters.adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.imageviewer.R;
import com.example.imageviewer.frameworks.network.GlideLoader;
import com.example.imageviewer.interface_adapters.presenters.InterfRecyclerMain;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.MainViewHolder> {
    private static final String TAG = "MainAdapter";

    private InterfRecyclerMain interfRecyclerMain;
    private GlideLoader glideLoader;

    public MainAdapter(InterfRecyclerMain interfRecyclerMain, Context context) {
        this.interfRecyclerMain = interfRecyclerMain;
        glideLoader = new GlideLoader(context);
    }

    @NonNull
    @Override
    public MainAdapter.MainViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_main, viewGroup, false);
        return new MainViewHolder (view);
    }

    @Override
    public void onBindViewHolder(@NonNull MainAdapter.MainViewHolder mainViewHolder, int position) {
        mainViewHolder.position = position;
        interfRecyclerMain.bindView(mainViewHolder);
    }

    @Override
    public int getItemCount() {
        return interfRecyclerMain.getItemCount();
    }

    public class MainViewHolder extends RecyclerView.ViewHolder implements InterfViewHolder {
        private int position = 0;
        @BindView(R.id.image_view_item)
        ImageView imageView;

        public MainViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @OnClick(R.id.image_view_item)
        public void onClickImageView() {
              int positopn = getAdapterPosition();
            Log.d(TAG, "Clicked position: " + positopn);
        }

        @Override
        public int getPos() {
            return position;
        }

        @Override
        public void setImage(String url) {
            glideLoader.loadImage(url, imageView);
        }
    }
}
