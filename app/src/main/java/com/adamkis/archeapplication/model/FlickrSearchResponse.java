package com.adamkis.archeapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import org.json.JSONObject;

/**
 * Created by adam on 7/25/15.
 */
public class FlickrSearchResponse {


    @Expose
    @SerializedName("photos")
    private FlickrResponsePhotosObject flickrResponsePhotosObject;

    @Expose
    @SerializedName("stat")
    private String stat;

    public FlickrResponsePhotosObject getFlickrResponsePhotosObject() {
        return flickrResponsePhotosObject;
    }

    public void setFlickrResponsePhotosObject(FlickrResponsePhotosObject flickrResponsePhotosObject) {
        this.flickrResponsePhotosObject = flickrResponsePhotosObject;
    }

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }


    @Override
    public String toString() {
        return "FlickrSearchResponse{" +
                "flickrResponsePhotosObject=" + flickrResponsePhotosObject +
                ", stat='" + stat + '\'' +
                '}';
    }
}
