package com.example.foodiapp.Fragments;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.foodiapp.Adapters.RandomRecipes;
import com.example.foodiapp.Interfaces.FoodApi;
import com.example.foodiapp.Interfaces.FoodApi2;
import com.example.foodiapp.Models.Food;
import com.example.foodiapp.Models.Result;
import com.example.foodiapp.R;
import com.example.foodiapp.RequestManager;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class PatientRecipies extends Fragment {
    private RecyclerView recyclerView;
    public RandomRecipes adapter = new RandomRecipes();
    private RecyclerView.LayoutManager layoutManager;
    private List<Food> myFoodList = new ArrayList<>();



    public PatientRecipies() {
       super(R.layout.fragment_patient_recipies);


    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        recyclerView = view.findViewById(R.id.rec_view);

        layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        loadRecipeData();
    }

    private void loadRecipeData() {
        FoodApi foodApi = (FoodApi) RequestManager.getFoodApi2();
        Call<List<Food>> call = foodApi.foodList2();
        call.enqueue(new Callback<List<Food>>() {
            @Override
            public void onResponse(Call<List<Food>> call, Response<List<Food>> response) {
                List<Food> foods = response.body();
                adapter.setMyFoodList(foods);
                recyclerView.setAdapter(adapter);
            }

            @Override
            public void onFailure(Call<List<Food>> call, Throwable t) {

            }
        });
    }

}