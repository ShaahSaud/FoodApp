package com.example.foodiapp.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.example.foodiapp.Models.Food;
import com.example.foodiapp.R;

import java.util.ArrayList;
import java.util.List;

public class RandomRecipes extends RecyclerView.Adapter<RandomRecipes.RecipesViewHolder> {

    private List<Food> mData = new ArrayList<>();

    public void setMyFoodList(List<Food> myFoodList) {
        this.mData = myFoodList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RecipesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recipe_row, parent, false);
        return new RecipesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecipesViewHolder holder, int position) {
        Food current = mData.get(position);
        Glide.with(holder.imageView.getContext()).load(current.getImage())
                .placeholder(R.drawable.ic_dashboard_black_24dp).into(holder.imageView);
        holder.nameView.setText(current.getTitle());
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }


    class RecipesViewHolder extends RecyclerView.ViewHolder {

    public ImageView imageView;
    public TextView nameView;

    RecipesViewHolder(View view) {
        super(view);
        imageView = view.findViewById(R.id.recipe_row_image_view);
        nameView = view.findViewById(R.id.recipe_row_text_view);
    }
}

}
