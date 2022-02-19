package com.example.foodiapp.Interfaces;



import com.example.foodiapp.Models.Food;
import com.example.foodiapp.Models.Result;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface FoodApi {

    @GET("recipes/random?number=20&")
    Call<Result> foodList();

    @GET("recipes/findByNutrients?number=20&maxSugar=5&")
    Call<List<Food>> foodList2();
}
