package com.example.coffeein;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.Camera;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.coffeein.databinding.ActivityProfileBinding;

import java.io.FileOutputStream;


public class ProfileActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityProfileBinding binding;

    ImageButton homebtn, favour, basket, profile;

    ImageView homeview, favourview, basketview, profileview, IVPreviewImage;

    EditText personname, number;

    SharedPreferences prefs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityProfileBinding.inflate(getLayoutInflater());
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
        basketview.setVisibility(View.INVISIBLE);
        profileview.setVisibility(View.VISIBLE);
        personname = binding.editTextTextPersonName;
        number = binding.editTextPhone;
        prefs = this.getSharedPreferences("com.example.coffeein", Context.MODE_PRIVATE);
        setTitle("Профиль");
    }

    @Override
    protected void onStop() {
        super.onStop();
        prefs.edit().putString("per", personname.getText().toString()).apply();
        prefs.edit().putString("nam", number.getText().toString()).apply();
    }

    @Override
    protected void onStart() {
        super.onStart();
        personname.setText(prefs.getString("per", ""));
        number.setText(prefs.getString("nam", ""));
    }

        @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.imageButton2:
                Intent intent2 = new Intent(this, MapActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent2);
                break;
            case R.id.imageButton3:
                Intent intent3 = new Intent(this, BasketActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent3);
                break;
            case R.id.imageButton:
                Intent intent4 = new Intent(this, MainActivity.class).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                startActivity(intent4);
                break;

        }
    }
}