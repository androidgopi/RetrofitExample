package com.sreeyainfotech.retrofitexample.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class AllData {

    @SerializedName("Alltimegreatgiftslist")
    private List<Alltimegreatgiftslist> alltimegreatgiftslists=new ArrayList<>();

    @SerializedName("HomePageProducts")
    private List<HomePageProducts> homePageProducts=new ArrayList<>();

    @SerializedName("Allcategories list")
    private List<Allcategorieslist> allcategories=new ArrayList<>();

    @SerializedName("seasonsspeciallist")
    private List<seasonsspeciallist> seasonsspeciallist=new ArrayList<>();

    public List<Alltimegreatgiftslist> getAlltimegreatgiftslists() {
        return alltimegreatgiftslists;
    }

    public void setAlltimegreatgiftslists(List<Alltimegreatgiftslist> alltimegreatgiftslists) {
        this.alltimegreatgiftslists = alltimegreatgiftslists;
    }

    public List<HomePageProducts> getHomePageProducts() {
        return homePageProducts;
    }

    public void setHomePageProducts(List<HomePageProducts> homePageProducts) {
        this.homePageProducts = homePageProducts;
    }

    public List<Allcategorieslist> getAllcategories() {
        return allcategories;
    }

    public void setAllcategories(List<Allcategorieslist> allcategories) {
        this.allcategories = allcategories;
    }

    public List<com.sreeyainfotech.retrofitexample.model.seasonsspeciallist> getSeasonsspeciallist() {
        return seasonsspeciallist;
    }

    public void setSeasonsspeciallist(List<com.sreeyainfotech.retrofitexample.model.seasonsspeciallist> seasonsspeciallist) {
        this.seasonsspeciallist = seasonsspeciallist;
    }
}
