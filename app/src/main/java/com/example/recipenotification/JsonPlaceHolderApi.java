package com.example.recipenotification;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface JsonPlaceHolderApi {

    @GET("vanessakoch/recipesJson/recipes")
    Call<List<Recipe>> getRecipes();

}
