package com.example.imageviewer.frameworks.network.api;

import com.example.imageviewer.entities.Photo;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import io.reactivex.Observable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHelper {
    public Observable<Photo> requestServer() {

        Gson gson = new GsonBuilder()
                .excludeFieldsWithoutExposeAnnotation()
                .create();

        GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create(gson);

        //http://pixabay.com/api/?key=17642382-a25f6304822f48a78c6193115
        InterfApiService api = new Retrofit.Builder()
                .baseUrl("https://pixabay.com")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(gsonConverterFactory)
                .build()
                .create(InterfApiService.class);

        return api.getPhoto("17642382-a25f6304822f48a78c6193115").subscribeOn(Schedulers.io());
    }
}
