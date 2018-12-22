package com.example.android.inventure.findhome_amir;

/**
 * Created by l on 13/09/2018.
 */

public class ModelList {

    int imageResourceID;

    String mainPlaceName, price, duration;

    float rating;

    public ModelList(int imageResourceID, String mainPlaceName, String price, String duration, float rating) {
        this.imageResourceID = imageResourceID;
        this.mainPlaceName = mainPlaceName;
        this.price = price;
        this.duration = duration;
        this.rating = rating;
    }

    public int getImageResourceID() {
        return imageResourceID;
    }

    public String getMainPlaceName() {
        return this.mainPlaceName;
    }

    public String getPrice() {
        return price;
    }

    public String getDuration() {
        return duration;
    }

    public float getRating() {
        return rating;
    }
}
