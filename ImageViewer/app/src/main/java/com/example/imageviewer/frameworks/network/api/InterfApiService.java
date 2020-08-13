package com.example.imageviewer.frameworks.network.api;

import com.example.imageviewer.entities.Photo;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface InterfApiService {
    @GET("api")
    Observable<Photo> getPhoto(@Query("key") String key);
}
