package com.example.coffeein;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.maps.*;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.coffeein.databinding.ActivityFavouriteBinding;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class FavouriteActivity extends AppCompatActivity implements View.OnClickListener, OnMapReadyCallback {

    private ActivityFavouriteBinding binding;

    ImageButton homebtn, favour, basket, profile;
    
    MapView googlemap;

    ImageView homeview, favourview, basketview, profileview;

    MapView googleMap;

    ActivityResultLauncher<Intent> startMainActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        if(intent != null){
                            String name = intent.getStringExtra("Name");
                            //binding.textView3.setText(name);
                        }
                    }
                    else{
                        String textError = "Error!";
                        //binding.textView3.setText(textError);
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> startBasketActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        if(intent != null){
                            String name = intent.getStringExtra("Name");
                            //binding.textView3.setText(name);
                        }
                    }
                    else{
                        String textError = "Error!";
                        //binding.textView3.setText(textError);
                    }
                }
            }
    );

    ActivityResultLauncher<Intent> startProfileActivityForResult = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
                @Override
                public void onActivityResult(ActivityResult result) {
                    if(result.getResultCode() == Activity.RESULT_OK){
                        Intent intent = result.getData();
                        if(intent != null){
                            String name = intent.getStringExtra("Name");
                            //binding.textView3.setText(name);
                        }
                    }
                    else{
                        String textError = "Error!";
                        //binding.textView3.setText(textError);
                    }
                }
            }
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityFavouriteBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        homebtn = binding.imageButton;
        favour = binding.imageButton2;
        basket = binding.imageButton3;
        profile = binding.imageButton4;
        homebtn.setOnClickListener(this);
        favour.setOnClickListener(this);
        basket.setOnClickListener(this);
        profile.setOnClickListener(this);
        homeview = binding.imageView9;
        favourview = binding.imageView10;
        basketview = binding.imageView11;
        profileview = binding.imageView12;
        googlemap = binding.mapView3;
        homeview.setVisibility(View.INVISIBLE);
        favourview.setVisibility(View.VISIBLE);
        basketview.setVisibility(View.INVISIBLE);
        profileview.setVisibility(View.INVISIBLE);
        setTitle("Карта");
        createMapView();
    }

    private void createMapView(){
        /**
         * Catch the null pointer exception that
         * may be thrown when initialising the map
         */
        try {
            if(null == googleMap){
                ((MapFragment) getFragmentManager().findFragmentById(
                        R.id.mapView3)).getMapAsync(this);

                /**
                 * If the map is still null after attempted initialisation,
                 * show an error to the user
                 */
                if(null == googleMap) {
                    Toast.makeText(getApplicationContext(),
                            "Error creating map",Toast.LENGTH_SHORT).show();
                }
            }
        } catch (NullPointerException exception){
            Log.e("mapApp", exception.toString());
        }
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton:
                Intent intent2 = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startMainActivityForResult.launch(intent2);
                break;
            case R.id.imageButton3:
                Intent intent3 = new Intent(this, BasketActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startBasketActivityForResult.launch(intent3);
                break;
            case R.id.imageButton4:
                Intent intent4 = new Intent(this, ProfileActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startProfileActivityForResult.launch(intent4);
                break;
        }
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap) {

    }
}