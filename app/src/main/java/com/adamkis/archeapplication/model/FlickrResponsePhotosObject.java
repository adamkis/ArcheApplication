package com.adamkis.archeapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by adam on 7/25/15.
 */
public class FlickrResponsePhotosObject {


    @Expose
    @SerializedName("photo")
    private List<FlickrPhotoObject> photoList = new ArrayList<FlickrPhotoObject>();


    @Expose
    @SerializedName("page")
    private int page;

    @Expose
    @SerializedName("pages")
    private int pages;

    @Expose
    @SerializedName("perpage")
    private int perpage;

    @Expose
    @SerializedName("total")
    private int total;


    public List<FlickrPhotoObject> getPhotoList() {
        return photoList;
    }

    public void setPhotoList(List<FlickrPhotoObject> photoList) {
        this.photoList = photoList;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public int getPerpage() {
        return perpage;
    }

    public void setPerpage(int perpage) {
        this.perpage = perpage;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "FlickrResponsePhotosObject{" +
                "photoList=" + photoList +
                ", page=" + page +
                ", pages=" + pages +
                ", perpage=" + perpage +
                ", total=" + total +
                '}';
    }
}
