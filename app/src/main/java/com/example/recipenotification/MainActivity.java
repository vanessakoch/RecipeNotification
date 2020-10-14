package com.example.recipenotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button btnDownloadRecipe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnDownloadRecipe = (Button) findViewById(R.id.btnDownloadRecipe);

    }

    public void onClickRecycler(View v) {
        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, RecyclerActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }
}