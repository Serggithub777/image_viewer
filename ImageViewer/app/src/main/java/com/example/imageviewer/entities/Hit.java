package com.example.imageviewer.entities;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

@Entity(tableName = "table_hits")
public class Hit {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public int position = 1;

    @Expose
    @SerializedName("webformatURL")
    public String webformatURL;


    @Override
    public String toString() {
        return "Hit{" +
                "id=" + id +
                ", webformatURL='" + webformatURL + '\'' +
                '}';
    }

}
