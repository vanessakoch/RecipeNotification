package com.example.recipenotification;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;

public class RecipeAdapter extends RecyclerView.Adapter {
    private Handler handler = new Handler();
    List<Recipe> recipeList;

    public RecipeAdapter(List<Recipe> recipeList) {
        this.recipeList = recipeList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        RecipeViewHolder viewHolder = new RecipeViewHolder(view);
        return viewHolder;
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        RecipeViewHolder viewHolder = (RecipeViewHolder) holder;
        String content = "";
        for(String s : recipeList.get(position).getIngredients()) {
            content += s + " \n";
        }
        viewHolder.ingredientsRecipe.setText(content);
        viewHolder.titleRecipe.setText(recipeList.get(position).getTitle());
        viewHolder.authorRecipe.setText(recipeList.get(position).getAuthor());

        new Thread() {
            public void run() {
                Bitmap bitmap = null;
                try {
                    URL urlImg = new URL(recipeList.get(position).getImage());
                    HttpURLConnection connection = (HttpURLConnection) urlImg.openConnection();
                    InputStream input = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(input);
                } catch (IOException e) {
                    e.printStackTrace();
                }

                final Bitmap imgAux = bitmap;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        viewHolder.imgRecipe.setImageBitmap(imgAux);
                    }
                });
            }
        }.start();
    }

    @Override
    public int getItemCount() {
        return recipeList.size();
    }

    public static class RecipeViewHolder extends RecyclerView.ViewHolder{

        TextView titleRecipe;
        TextView authorRecipe;
        TextView ingredientsRecipe;
        ImageView imgRecipe;

        public RecipeViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setTag(this);
            ingredientsRecipe = (TextView) itemView.findViewById(R.id.ingredientsRecipe);
            titleRecipe = (TextView) itemView.findViewById(R.id.titleRecipe);
            authorRecipe = (TextView) itemView.findViewById(R.id.authorRecipe);
            imgRecipe = (ImageView) itemView.findViewById(R.id.imgRecipe);
        }
    }

}
