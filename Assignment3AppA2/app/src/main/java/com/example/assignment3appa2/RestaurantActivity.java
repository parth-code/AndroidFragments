package com.example.assignment3appa2;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class RestaurantActivity extends AppCompatActivity implements RestaurantListFragment.ListSelectionListener {
    int mShownIndex = -1;
    static String OLD_ITEM = "old_item";
    RestaurantListFragment restaurantListFragment = null;
    AttractionWebFragment attractionWebFragment = null;

    Menu optionMenu;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i("ERROR", "ajkshdkjhd;k");
        if(getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT){
            setContentView(R.layout.vertical_layout);
        } else {
            setContentView(R.layout.horizontal_layout);
        }
        Toolbar myToolbar= findViewById(R.id.toolbar_1);
        setSupportActionBar(myToolbar);

        Log.i("TAG", "Entered OnCreate");

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        restaurantListFragment = new RestaurantListFragment();
        attractionWebFragment = new AttractionWebFragment();

        mShownIndex = -1;

        fragmentTransaction.replace(R.id.name_list, restaurantListFragment);
//        fragmentTransaction.replace(R.id.website, attractionWebFragment);
        Log.i("TAG", "replaced fragments");

        fragmentTransaction.commit();
        Log.i("TAG", "committed transaction");
        if(savedInstanceState!= null){ mShownIndex = savedInstanceState.getInt(OLD_ITEM);}
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
                Intent attraction = new Intent(RestaurantActivity.this, AttractionActivity.class);
//                attraction.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(attraction);
            case R.id.restaurant:
//                Intent restaurant = new Intent(RestaurantActivity.this, RestaurantActivity.class);
////                restaurant.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                startActivity(restaurant);
                Toast.makeText(RestaurantActivity.this, "You're in the Restaurant Activity", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onStart() {
        super.onStart();
        if(mShownIndex!= -1){
            restaurantListFragment.setSelection(mShownIndex);
            restaurantListFragment.getListView().setItemChecked(mShownIndex, true);
            attractionWebFragment.getUrlForWebsite(DataMap.restaurantWebMap.keySet().toArray()[mShownIndex].toString());
        }
    }

    @Override
    public void onListSelection ( int index){
        if(mShownIndex!= index){
            attractionWebFragment.getUrlForWebsite(DataMap.restaurantWebMap.keySet().toArray()[index].toString());
            mShownIndex = index;
        }
    }

    public void onSaveInstanceState(Bundle bundle){
        super.onSaveInstanceState(bundle);
        if(mShownIndex != -1){
            bundle.putInt(OLD_ITEM, mShownIndex);
        }   else {
            bundle.putInt(OLD_ITEM, -1);
        }
    }
}

