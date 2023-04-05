package com.example.coffeein;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.coffeein.databinding.ActivityBasketBinding;

public class BasketActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityBasketBinding binding;

    ImageButton homebtn, favour, basket, profile;

    ImageView homeview, favourview, basketview, profileview;


    ActivityResultLauncher<Intent> startFavouriteActivityForResult = registerForActivityResult(
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
        binding = ActivityBasketBinding.inflate(getLayoutInflater());
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
        homeview.setVisibility(View.INVISIBLE);
        favourview.setVisibility(View.INVISIBLE);
        basketview.setVisibility(View.VISIBLE);
        profileview.setVisibility(View.INVISIBLE);
        setTitle("Корзина");
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                Intent intent2 = new Intent(this, FavouriteActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startFavouriteActivityForResult.launch(intent2);
                homeview.setVisibility(View.INVISIBLE);
                favourview.setVisibility(View.VISIBLE);
                basketview.setVisibility(View.INVISIBLE);
                profileview.setVisibility(View.INVISIBLE);
                break;
            case R.id.imageButton:
                Intent intent3 = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startMainActivityForResult.launch(intent3);
                homeview.setVisibility(View.VISIBLE);
                favourview.setVisibility(View.INVISIBLE);
                basketview.setVisibility(View.INVISIBLE);
                profileview.setVisibility(View.INVISIBLE);
                break;
            case R.id.imageButton4:
                Intent intent4 = new Intent(this, ProfileActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startProfileActivityForResult.launch(intent4);
                homeview.setVisibility(View.INVISIBLE);
                favourview.setVisibility(View.INVISIBLE);
                basketview.setVisibility(View.INVISIBLE);
                profileview.setVisibility(View.VISIBLE);
                break;
        }
    }
}