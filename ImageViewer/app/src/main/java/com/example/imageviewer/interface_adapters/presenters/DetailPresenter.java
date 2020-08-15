package com.example.imageviewer.interface_adapters.presenters;

import android.util.Log;

import com.example.imageviewer.entities.Hit;
import com.example.imageviewer.entities.Photo;
import com.example.imageviewer.frameworks.network.api.ApiHelper;
import com.example.imageviewer.frameworks.view.InterfDetailActivity;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<InterfDetailActivity> {
    private static final String TAG = "DetailPresenter";

   private Photo photo = new Photo();
   private List<Hit> hitList = photo.getHits();
   private String url;
   private ApiHelper apiHelper;

    public void getUrlByPosition(int position) {
        apiHelper = new ApiHelper();
        Observable<Photo> single = apiHelper.requestServer();

        Disposable disposable = single.observeOn(AndroidSchedulers.mainThread()).subscribe(photos -> {
            hitList = photos.hits;
            url = hitList.get(position).webformatURL;
            Log.d(TAG, "DetailPresenter: " + url);
            getViewState().setImage(url);

        }, throwable -> {
            Log.e(TAG, "onError " + throwable);
        });

    }
}
