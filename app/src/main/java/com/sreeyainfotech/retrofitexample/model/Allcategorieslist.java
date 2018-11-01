package com.sreeyainfotech.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Allcategorieslist implements Serializable{

    @SerializedName("image_path")
    private String image_path;

    @SerializedName("category_name")
    private String category_name;

    @SerializedName("category_id")
    private String category_id;

    public String getImage_path() {
        return image_path;
    }

    public void setImage_path(String image_path) {
        this.image_path = image_path;
    }

    public String getCategory_name() {
        return category_name;
    }

    public void setCategory_name(String category_name) {
        this.category_name = category_name;
    }

    public String getCategory_id() {
        return category_id;
    }

    public void setCategory_id(String category_id) {
        this.category_id = category_id;
    }
}
