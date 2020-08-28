package com.example.imageviewer.interface_adapters.presenters;

import android.util.Log;

import com.example.imageviewer.App;
import com.example.imageviewer.entities.Hit;
import com.example.imageviewer.entities.Photo;
import com.example.imageviewer.frameworks.data_base.HitDao;
import com.example.imageviewer.frameworks.network.api.ApiHelper;
import com.example.imageviewer.frameworks.view.InterfDetailActivity;

import java.util.List;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import moxy.InjectViewState;
import moxy.MvpPresenter;

@InjectViewState
public class DetailPresenter extends MvpPresenter<InterfDetailActivity> {
    private static final String TAG = "DetailPresenter";

   private Photo photo = new Photo();
   private List<Hit> hitList = photo.getHits();
   private String url;
   private ApiHelper apiHelper;
   private HitDao hitDao;

    public DetailPresenter() {
        hitDao = App.getAppDatabase().hitDao();
    }

    public void getUrlByPosition(int position) {
       url = getURLofHit(position);
        getViewState().setImage(url);
    }

    private String getURLofHit(int position) {
        Disposable disposables = hitDao.getHitById(position).subscribeOn(Schedulers.io())
                .subscribe(hits->{
                    url = hits.get(0).webformatURL;

                    Log.d(TAG, "getUrlByPosition: " + url);
                 }, throwable -> {
                    Log.d(TAG, "getUrlByPosition: " + throwable);
                });
        return url;
    }
}
