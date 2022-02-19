package com.example.foodiapp;

import com.example.foodiapp.Interfaces.FoodApi;
import com.example.foodiapp.Interfaces.FoodApi2;

import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RequestManager {

    private static final String BASE_URL ="https://api.spoonacular.com/";
    private static final String API_KEY = "d9ee0d236fb548ef94cfb6dd732d26a0";
    public static Retrofit retrofit;
    public static FoodApi foodApi = null;
    public static FoodApi2 foodApi2 = null;

    public static Retrofit getRetrofitClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

        httpClient.addInterceptor(chain -> {
            Request original = chain.request();
            HttpUrl url = original.url().newBuilder()
                    .addQueryParameter("apiKey", API_KEY).build();
            original = original.newBuilder().url(url).build();
            return chain.proceed(original);
        });
        httpClient.addInterceptor(interceptor);
        OkHttpClient client = httpClient.build();

        if (retrofit == null) {
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public static FoodApi getFoodApi() {
        if (foodApi == null) {
            foodApi = getRetrofitClient().create(FoodApi.class);
        }
        return foodApi;
    }

    public static FoodApi getFoodApi2() {
        if (foodApi == null) {
            foodApi = getRetrofitClient().create(FoodApi.class);
        }
        return foodApi;
    }


}
