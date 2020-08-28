package com.example.imageviewer.frameworks.data_base;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.imageviewer.entities.Hit;

import java.util.List;

import io.reactivex.Single;
import io.reactivex.disposables.Disposable;

@Dao
public interface HitDao {
    @Query("SELECT * FROM table_hits WHERE position = :position")
    Single<List<Hit>> getHitById(int position);

    @Insert
    Single<Long> insert(Hit hit);

    @Insert
    Single<List<Long>> insertList(List<Hit> hits);

    @Delete
    Single<Integer> delete(Hit ht);

    @Update
    Single<Integer> update(Hit hit);

    @Query ("DELETE FROM table_hits;")
    Single<Integer>  clearTable();
}
