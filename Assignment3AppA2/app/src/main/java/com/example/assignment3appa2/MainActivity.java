package com.example.assignment3appa2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import android.app.ActionBar;

public class MainActivity extends AppCompatActivity {
    static final String ATTRACTION_INTENT = "com.example.ATTRACTION_INTENT";
    static final String RESTAURANT_INTENT = "com.example.RESTAURANT_INTENT";
    Menu optionMenu;
    BroadcastReceiver appA1AttractionReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
//      Toast.makeText(context, "Starting restaurant activity A2", Toast.LENGTH_LONG).show();
        Intent attractionIntent = new Intent(MainActivity.this, AttractionActivity.class);
        attractionIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(attractionIntent);
        }
    };
    BroadcastReceiver appA1RestaurantReceiver = new BroadcastReceiver(){
        @Override
        public void onReceive(Context context, Intent intent) {
//        Toast.makeText(context, "Starting attraction activity A2", Toast.LENGTH_LONG).show();
        Intent restaurantIntent = new Intent(MainActivity.this, RestaurantActivity.class);
        restaurantIntent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(restaurantIntent);
        }
    };
    IntentFilter restaurantFilter = new IntentFilter(RESTAURANT_INTENT);
    IntentFilter attractionFilter = new IntentFilter(ATTRACTION_INTENT);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar myToolbar= (Toolbar) findViewById(R.id.toolbar_1) ;
        setSupportActionBar(myToolbar);

        restaurantFilter.setPriority(10);
        attractionFilter.setPriority(20);
        int permissionCheck = ContextCompat.checkSelfPermission(MainActivity.this, "edu.uic.cs478.sp2020.project3");
        if(PackageManager.PERMISSION_GRANTED == permissionCheck) {
            registerReceiver(appA1RestaurantReceiver, restaurantFilter);
            registerReceiver(appA1AttractionReceiver, attractionFilter);
        } else {
            ActivityCompat.requestPermissions(MainActivity.this, new String[]{"edu.uic.cs478.sp2020.project3"},100);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_bar_1, menu);
        optionMenu = menu;
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int attractionid = optionMenu.getItem(0).getItemId();
        switch (item.getItemId()) {
            case R.id.attraction:
                Intent attraction = new Intent(MainActivity.this, AttractionActivity.class);
                startActivity(attraction);
            case R.id.restaurant:
                Intent restaurant = new Intent(MainActivity.this, RestaurantActivity.class);
                startActivity(restaurant);
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        unregisterReceiver(appA1RestaurantReceiver);
        unregisterReceiver(appA1AttractionReceiver);
    }
}
