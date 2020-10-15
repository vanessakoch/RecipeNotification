package com.example.recipenotification;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static com.example.recipenotification.App.CHANNEL_1_ID;
import static com.example.recipenotification.App.CHANNEL_2_ID;

public class MainActivity extends AppCompatActivity {
    private NotificationManagerCompat notificationManagerCompat;
    private Button btnDownloadRecipe;
    private TextView txtTitleToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        notificationManagerCompat = NotificationManagerCompat.from(this);
        btnDownloadRecipe = (Button) findViewById(R.id.btnDownloadRecipe);
        txtTitleToolbar = (TextView) findViewById(R.id.txtTitleToolbar);
        txtTitleToolbar.setText("");
    }

    public void onClickRecycler(View v) {

        sendChannel1();

        Bundle bundle = new Bundle();
        Intent intent = new Intent(this, RecyclerActivity.class);
        intent.putExtras(bundle);
        startActivityForResult(intent, 1);
    }

    public void sendChannel1(){
        Notification notification = new NotificationCompat.Builder(this, CHANNEL_1_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Hummmm...")
                .setContentText("As melhores receitas estão prontas!")
                .setPriority(NotificationCompat.PRIORITY_HIGH)
                .setCategory(NotificationCompat.CATEGORY_MESSAGE)
                .build();

        notificationManagerCompat.notify(1, notification);
    }

    public void sendChannel2(){

        Notification notification = new NotificationCompat.Builder(this, CHANNEL_2_ID)
                .setSmallIcon(R.drawable.ic_baseline_notifications_24)
                .setContentTitle("Hummmm...")
                .setContentText("As melhores receitas estão prontas!")
                .setPriority(NotificationCompat.PRIORITY_LOW)
                .build();

        notificationManagerCompat.notify(2, notification);
    }
}