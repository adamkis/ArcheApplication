package com.adamkis.archeapplication.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by adam on 7/25/15.
 */
public class FlickrPhotoObject {



    @Expose
    @SerializedName("id")
    private long id;

    @Expose
    @SerializedName("owner")
    private String owner;

    @Expose
    @SerializedName("secret")
    private String secret;

    @Expose
    @SerializedName("server")
    private int server;

    @Expose
    @SerializedName("farm")
    private int farm;

    @Expose
    @SerializedName("title")
    private String title;

    @Expose
    @SerializedName("ispublic")
    private int isPublic;

    @Expose
    @SerializedName("isfriend")
    private int isFriend;

    @Expose
    @SerializedName("isfamily")
    private int isFamily;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getSecret() {
        return secret;
    }

    public void setSecret(String secret) {
        this.secret = secret;
    }

    public int getServer() {
        return server;
    }

    public void setServer(int server) {
        this.server = server;
    }

    public int getFarm() {
        return farm;
    }

    public void setFarm(int farm) {
        this.farm = farm;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getIsPublic() {
        return isPublic;
    }

    public void setIsPublic(int isPublic) {
        this.isPublic = isPublic;
    }

    public int getIsFriend() {
        return isFriend;
    }

    public void setIsFriend(int isFriend) {
        this.isFriend = isFriend;
    }

    public int getIsFamily() {
        return isFamily;
    }

    public void setIsFamily(int isFamily) {
        this.isFamily = isFamily;
    }

    public String getPhotoUrl(){

        StringBuilder photoUrlBuilder = new StringBuilder();
        photoUrlBuilder.append("https://farm");
        photoUrlBuilder.append(getFarm());
        photoUrlBuilder.append(".staticflickr.com/");
        photoUrlBuilder.append(getServer());
        photoUrlBuilder.append("/");
        photoUrlBuilder.append(getId());
        photoUrlBuilder.append("_");
        photoUrlBuilder.append(getSecret());
        photoUrlBuilder.append(".jpg");

        return photoUrlBuilder.toString();
    }

    @Override
    public String toString() {
        return "FlickrPhotoObject{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                ", secret='" + secret + '\'' +
                ", server=" + server +
                ", farm=" + farm +
                ", title='" + title + '\'' +
                ", isPublic=" + isPublic +
                ", isFriend=" + isFriend +
                ", isFamily=" + isFamily +
                '}';
    }
}
