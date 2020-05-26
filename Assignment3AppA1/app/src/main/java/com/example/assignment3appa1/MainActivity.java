package com.example.assignment3appa1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    static final String ATTRACTION_INTENT = "com.example.ATTRACTION_INTENT";
    static final String RESTAURANT_INTENT = "com.example.RESTAURANT_INTENT";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button attractionButton = findViewById(R.id.button1);
        final Button restaurantButton = findViewById(R.id.button2);

        attractionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent attractionIntent = new Intent(ATTRACTION_INTENT);
                attractionIntent.putExtra("intentNum", true);
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, "edu.uic.cs478.sp2020.project3");
                if(PackageManager.PERMISSION_GRANTED == permissionCheck) {
                    Toast.makeText(MainActivity.this, "Starting attraction activity", Toast.LENGTH_LONG).show();
                    sendBroadcast(attractionIntent);
                } else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{"edu.uic.cs478.sp2020.project3"},0);
                }
            }
        });

        restaurantButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent restaurantIntent = new Intent(RESTAURANT_INTENT);
                int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, "edu.uic.cs478.sp2020.project3");
                if(PackageManager.PERMISSION_GRANTED == permissionCheck) {
                    Toast.makeText(MainActivity.this, "Starting restaurant activity", Toast.LENGTH_LONG).show();
                    sendBroadcast(restaurantIntent);
                }else {
                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{"edu.uic.cs478.sp2020.project3"},0);
                }
            }
        });

    }
}
