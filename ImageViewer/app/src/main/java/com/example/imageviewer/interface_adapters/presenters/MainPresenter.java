package com.example.imageviewer.interface_adapters.presenters;

import android.util.Log;

import com.example.imageviewer.entities.Hit;
import com.example.imageviewer.entities.Photo;
import com.example.imageviewer.frameworks.network.api.ApiHelper;
import com.example.imageviewer.frameworks.view.MainView;
import com.example.imageviewer.interface_adapters.adapters.InterfViewHolder;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class MainPresenter extends MvpPresenter<MainView> {
    private static final String TAG = "MainPresenter";

    private RecyclerMain recyclerMain;
    private ApiHelper apiHelper;
    private List<Hit> hitList;

    public MainPresenter() {
        Log.d(TAG, "MainPresenter: ");
        recyclerMain = new RecyclerMain();
        apiHelper = new ApiHelper();
    }

    @Override
    protected void onFirstViewAttach() {
        getAllPhoto();
    }

    public void getAllPhoto() {
        Observable<Photo> single = apiHelper.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photos -> {
            hitList = photos.hits;

            getViewState().updateRecyclerView();

        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });
    }

    private class RecyclerMain implements InterfRecyclerMain {

        @Override
        public void bindView(InterfViewHolder iViewHolder) {
            iViewHolder.setImage(hitList.get(iViewHolder.getPos()).webformatURL);
        }

        @Override
        public int getItemCount() {
            if (hitList != null) {
                return hitList.size();
            }
            return 0;
        }
    }

    public RecyclerMain getRecyclerMain() {
        return recyclerMain;
    }
}
