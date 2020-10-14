package com.example.recipenotification;

import android.net.Uri;

import com.google.gson.annotations.SerializedName;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class Recipe {
    private String id;
    private String image;
    private String title;
    private String author;
    private List<String> ingredients;
    private List<String> preparation;
    private String information;

    public Recipe(String id, String image, String title, String author, List<String> ingredients, List<String> preparation, String information) {
        this.id = id;
        this.image = image;
        this.title = title;
        this.author = author;
        this.ingredients = new ArrayList<String>();
        this.preparation = new ArrayList<String>();
        this.information = information;
    }

    public String getId() {
        return id;
    }

    public String getImage() {
        return image;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public List<String> getPreparation() {
        return preparation;
    }

    public String getInformation() {
        return information;
    }

    @Override
    public String toString() {
        return "Recipe{" +
                "id='" + id + '\'' +
                ", image='" + image + '\'' +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", ingredients=" + ingredients +
                ", preparation=" + preparation +
                ", information='" + information + '\'' +
                '}';
    }
}
