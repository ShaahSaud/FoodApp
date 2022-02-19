package com.example.foodiapp.Models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Result {

    @SerializedName("recipes")
    private List<Food> result = null;

    public List<Food> getResult() {
        return  result;
    }

//    @SerializedName("")
//    private List<Food> result2 = null;
//
//    public List<Food> getResult2() {
//        return  result2;
//    }

}
